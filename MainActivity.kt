Alexsandro Soares da silva filho, 1 min
package com.example.beta
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.
ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.beta.model.Onibus
import com.example.beta.model.Passageiro
import com.example.beta.model.Viagem
private val Azul = Color(0xFF174A7E)
private val AzulClaro = Color(0xFF4D8FC7)
private val Amarelo = Color(0xFFFFC928)
private val Fundo = Color(0xFFF2F7FC)
private val Texto = Color(0xFF172B3A)
private val Cinza = Color(0xFF657586)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent 
{
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Azul,
                    secondary = AzulClaro,
                    tertiary = Amarelo,
                    background = Fundo,
                    surface = Color.White,
                    onPrimary = Color.White,
                    onBackground = Texto,
                    onSurface = 
Texto
                )
            ) 
{
                BetaTurismo()
            
}
        }
    }
}
@Composable
fun BetaTurismo() {
    val viagens = remember { mutableStateListOf<Viagem>() 
}
    val onibus = remember { mutableStateListOf<Onibus>() 
}
    val passageiros = remember { mutableStateListOf<Passageiro>() 
}
    var tela by remember { mutableStateOf("inicio") 
}
    var menuAberto by remember { mutableStateOf(false) 
}
    var viagemSelecionada by remember { mutableStateOf<Viagem?>(null) 
}
    var excluirViagemIndice by remember { mutableStateOf<Int?>(null) 
}
    var excluirPassageiroIndice by remember { mutableStateOf<Int?>(null) 
}
    var passageiroEditandoIndice by remember { mutableStateOf<Int?>(null) 
}
    var mostrarFormularioPassageiro by remember { mutableStateOf(false) 
}
    var buscaPassageiro by remember { mutableStateOf("") 
}
    Scaffold(
        containerColor = Fundo,
        topBar = 
{
            Surface(color = Azul) 
{
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    horizontalAlignment = Alignment.
CenterHorizontally
                ) 
{
                    Text("Beta Turismo", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Text("Gestão de viagens", color = Color.White)
                
}
            }
        },
        floatingActionButton = 
{
            if (tela == "inicio") {
                Box 
{
                    FloatingActionButton(
                        onClick = { menuAberto = true },
                        containerColor = Amarelo,
                        contentColor = 
Texto
                    ) { Text("+", fontSize = 28.sp) 
}
                    DropdownMenu(expanded = menuAberto, onDismissRequest = { menuAberto = false }) 
{
                        DropdownMenuItem(
                            text = { Text("Adicionar viagem") },
                            onClick = { menuAberto = false; tela = "novaViagem" 
}
                        )
                        DropdownMenuItem(
                            text = { Text("Adicionar ônibus") },
                            onClick = { menuAberto = false; tela = "novoOnibus" 
}
                        )
                        DropdownMenuItem(
                            text = { Text("Passageiros e pagamentos") },
                            onClick = { menuAberto = false; tela = "passageiros" 
}
                        )
                    
}
                }
            }
        
}
    ) { espaco 
->
        Column(
            modifier = Modifier.fillMaxSize().padding(espaco).padding(16.dp)
        ) 
{
            when (tela) {
                "inicio" -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.
CenterVertically
                    ) 
{
                        Text("Viagens cadastradas", fontSize = 21.sp, fontWeight = FontWeight.Bold, color = Azul)
                        TextButton(onClick = { tela = "frota" }) { Text("Frota") 
}
                    }
                    Spacer(Modifier.height(8.dp))
                    if (viagens.isEmpty()) {
                        Text("Você ainda não cadastrou nenhuma viagem.", color = Cinza)
                    } else {
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) 
{
                            itemsIndexed(viagens) { indice, viagem 
->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) 
{
                                    Column(Modifier.padding(16.dp)) 
{
                                        Text("${viagem.origem} → ${viagem.destino}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Azul)
                                        Text("Viagem: ${viagem.nome}")
                                        Text("Ida: ${viagem.ida}")
                                        Text("Volta: ${viagem.volta}")
                                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) 
{
                                            Button(
                                                onClick = { viagemSelecionada = viagem; tela = "detalhes" },
                                                modifier = Modifier.weight(1f)
                                            ) { Text("Ver detalhes") 
}
                                            OutlinedButton(onClick = { excluirViagemIndice = indice }) { Text("Excluir") 
}
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    OutlinedButton(onClick = { tela = "passageiros" }, modifier = Modifier.fillMaxWidth()) 
{
                        Text("Passageiros e pagamentos")
                    
}
                }
                "novaViagem" -> FormularioViagem(
                    onCancelar = { tela = "inicio" },
                    onSalvar = { viagens.add(it); tela = "inicio" 
}
                )
                "novoOnibus" -> FormularioOnibus(
                    onCancelar = { tela = "inicio" },
                    onSalvar = { onibus.add(it); tela = "frota" 
}
                )
                "frota" -> {
                    Titulo("Frota de ônibus")
                    if (onibus.isEmpty()) {
                        Text("Nenhum ônibus cadastrado.")
                    } else {
                        LazyColumn(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) 
{
                            itemsIndexed(onibus) { _, bus 
->
                                Card(modifier = Modifier.fillMaxWidth()) 
{
                                    Column(Modifier.padding(14.dp)) 
{
                                        Text(bus.nome, fontWeight = FontWeight.Bold)
                                        Text("Placa: ${bus.placa.ifBlank { "Não informada" }}")
                                        Text("Assentos: ${bus.assentos}")
                                        Text("Espaços acessíveis: ${bus.acessiveis}")
                                    
}
                                }
                            }
                        }
                    }
                    BotaoVoltar { tela = "inicio" 
}
                }
                "detalhes" -> {
                    Titulo(viagemSelecionada?.nome ?: "Detalhes da viagem")
                    viagemSelecionada?.let 
{
                        Text("${it.origem} → ${it.destino}")
                        Text("Ida: ${it.ida} | Volta: ${it.volta}")
                        Text("Preço por passageiro: R$ ${it.preco}")
                    
}
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = { tela = "onibusViagem" }, modifier = Modifier.fillMaxWidth()) 
{
                        Text("Ônibus e assentos")
                    
}
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { tela = "passageiros" }, modifier = Modifier.fillMaxWidth()) 
{
                        Text("Passageiros e pagamentos")
                    
}
                    BotaoVoltar { tela = "inicio" 
}
                }
                "onibusViagem" -> {
                    Titulo("Ônibus e assentos")
                    if (onibus.isEmpty()) Text("Cadastre um ônibus na tela inicial primeiro.")
                    else onibus.forEach { Text("${it.nome} — ${it.assentos} assentos") 
}
                    Spacer(Modifier.height(8.dp))
                    Text("A distribuição visual dos assentos ainda não foi implementada.")
                    BotaoVoltar { tela = "detalhes" 
}
                }
                "passageiros" -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.
SpaceBetween
                    ) 
{
                        Titulo("Passageiros")
                        Button(onClick = { passageiroEditandoIndice = null; mostrarFormularioPassageiro = true }) 
{
                            Text("+ Adicionar")
                        
}
                    }
                    OutlinedTextField(
                        value = buscaPassageiro,
                        onValueChange = { buscaPassageiro = it },
                        label = { Text("Buscar por nome ou CPF") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = 
true
                    )
                    Spacer(Modifier.height(8.dp))
                    val filtrados = passageiros.withIndex().filter 
{
                        it.value.nome.contains(buscaPassageiro, ignoreCase = true) ||
                                it.value.cpf.contains(buscaPassageiro, ignoreCase = true)
                    
}
                    if (filtrados.isEmpty()) {
                        Text(
                            if (passageiros.isEmpty()) 
"Nenhum passageiro cadastrado. Toque em + Adicionar para cadastrar."
                            else "Nenhum passageiro encontrado.",
                            color = 
Cinza
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) 
{
                            itemsIndexed(filtrados, key = { _, item -> item.index }) { _, item 
->
                                val passageiro = item.
value
                                Card(modifier = Modifier.fillMaxWidth()) 
{
                                    Column(Modifier.fillMaxWidth().padding(12.dp)) 
{
                                        Text(passageiro.nome, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Azul)
                                        Text("CPF: ${passageiro.cpf.ifBlank { "Não informado" }}  •  RG: ${passageiro.rg.ifBlank { "Não informado" }}")
                                        Text("Ônibus: ${passageiro.onibus.ifBlank { "Não definido" }}  •  Assento: ${passageiro.assento.ifBlank { "Não definido" }}")
                                        Text("Valor: R$ ${passageiro.preco}  •  ${passageiro.formaPagamento}")
                                        Text(
                                            "Pagamento: ${passageiro.statusPagamento}",
                                            color = if (passageiro.statusPagamento == "Pago") Color(0xFF247A3D) else Color(0xFFB3261E),
                                            fontWeight = FontWeight.
SemiBold
                                        )
                                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) 
{
                                            OutlinedButton(
                                                onClick = { passageiroEditandoIndice = item.index; mostrarFormularioPassageiro = true },
                                                modifier = Modifier.weight(1f)
                                            ) { Text("Editar") 
}
                                            Button(
                                                onClick = 
{
                                                    passageiros[item.index] = passageiro.copy(
                                                        statusPagamento = if (passageiro.statusPagamento == "Pago") "Pendente" else 
"Pago"
                                                    )
                                                },
                                                modifier = Modifier.weight(1f)
                                            ) 
{
                                                Text(if (passageiro.statusPagamento == "Pago") "Marcar pendente" else "Marcar pago")
                                            
}
                                            OutlinedButton(onClick = { excluirPassageiroIndice = item.index }) { Text("Excluir") 
}
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    BotaoVoltar { tela = if (viagemSelecionada != null) "detalhes" else "inicio" 
}
                }
            }
        
}
    }
    if (mostrarFormularioPassageiro) {
        val indice = passageiroEditandoIndice
        val passageiroAtual = indice?.let { passageiros.getOrNull(it) 
}
        FormularioPassageiro(
            passageiroInicial = passageiroAtual,
            onCancelar = { mostrarFormularioPassageiro = false; passageiroEditandoIndice = null },
            onSalvar = { novo 
->
                if (indice == null) passageiros.add(novo) else passageiros[indice] = novo
                mostrarFormularioPassageiro = 
false
                passageiroEditandoIndice = 
null
            },
            nomesOnibus = onibus.map { it.nome 
}
        )
    }
    excluirViagemIndice?.let { indice 
->
        if (indice in viagens.indices) {
            AlertDialog(
                onDismissRequest = { excluirViagemIndice = null },
                title = { Text("Excluir viagem?") },
                text = { Text("Deseja excluir ${viagens[indice].nome}?") },
                confirmButton = 
{
                    TextButton(onClick = { viagens.removeAt(indice); excluirViagemIndice = null }) { Text("Excluir") 
}
                },
                dismissButton = { TextButton(onClick = { excluirViagemIndice = null }) { Text("Cancelar") 
} }
            )
        }
    
}
    excluirPassageiroIndice?.let { indice 
->
        if (indice in passageiros.indices) {
            AlertDialog(
                onDismissRequest = { excluirPassageiroIndice = null },
                title = { Text("Excluir passageiro?") },
                text = { Text("Deseja excluir ${passageiros[indice].nome}?") },
                confirmButton = 
{
                    TextButton(onClick = { passageiros.removeAt(indice); excluirPassageiroIndice = null }) { Text("Excluir") 
}
                },
                dismissButton = { TextButton(onClick = { excluirPassageiroIndice = null }) { Text("Cancelar") 
} }
            )
        }
    
}
}
@Composable
fun FormularioViagem(onCancelar: () -> Unit, onSalvar: (Viagem) -> Unit) {
    var nome by remember { mutableStateOf("") 
}
    var origem by remember { mutableStateOf("") 
}
    var destino by remember { mutableStateOf("") 
}
    var ida by remember { mutableStateOf("") 
}
    var volta by remember { mutableStateOf("") 
}
    var preco by remember { mutableStateOf("") 
}
    var erro by remember { mutableStateOf("") 
}
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) 
{
        Titulo("Cadastrar viagem")
        Campo("Nome da viagem", nome) { nome = 
it }
        Campo("Cidade de origem", origem) { origem = 
it }
        Campo("Cidade de destino", destino) { destino = 
it }
        Campo("Data de ida (dd/mm/aaaa)", ida) { ida = 
it }
        Campo("Data de volta (dd/mm/aaaa)", volta) { volta = 
it }
        Campo("Preço por passageiro (ex.: 250.00)", preco) { preco = 
it }
        if (erro.isNotBlank()) Text(erro, color = MaterialTheme.colorScheme.error)
        Button(
            onClick = 
{
                val valor = preco.replace(",", ".").toDoubleOrNull()
                erro = when {
                    nome.isBlank() || origem.isBlank() || destino.isBlank() || ida.isBlank() || volta.isBlank() -> 
"Preencha todos os campos."
                    valor == null || valor < 0 -> 
"Informe um preço válido, por exemplo 250.00."
                    else -> 
""
                }
                if (erro.isEmpty()) onSalvar(Viagem(nome.trim(), origem.trim(), destino.trim(), ida.trim(), volta.trim(), String.format(java.util.Locale.US, "%.2f", valor)))
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Cadastrar viagem") 
}
        BotaoVoltar(onCancelar)
    
}
}
@Composable
fun FormularioOnibus(onCancelar: () -> Unit, onSalvar: (Onibus) -> Unit) {
    var nome by remember { mutableStateOf("") 
}
    var placa by remember { mutableStateOf("") 
}
    var assentos by remember { mutableStateOf("") 
}
    var acessiveis by remember { mutableStateOf("0") 
}
    var erro by remember { mutableStateOf("") 
}
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) 
{
        Titulo("Cadastrar ônibus")
        Campo("Nome ou identificação", nome) { nome = 
it }
        Campo("Placa (opcional)", placa) { placa = 
it }
        Campo("Quantidade de assentos", assentos) { assentos = 
it }
        Campo("Espaços acessíveis", acessiveis) { acessiveis = 
it }
        if (erro.isNotBlank()) Text(erro, color = MaterialTheme.colorScheme.error)
        Button(
            onClick = 
{
                val total = assentos.toIntOrNull()
                val vagas = acessiveis.toIntOrNull()
                erro = if (nome.isBlank() || total == null || total <= 0 || vagas == null || vagas < 0 || vagas > total) {
                    
"Informe identificação e quantidades válidas. Espaços acessíveis não podem superar os assentos."
                } else 
""
                if (erro.isEmpty()) onSalvar(Onibus(nome.trim(), placa.trim(), total!!, vagas!!))
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Cadastrar ônibus") 
}
        BotaoVoltar(onCancelar)
    
}
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioPassageiro(
    passageiroInicial: Passageiro?,
    onCancelar: () -> Unit,
    onSalvar: (Passageiro) -> Unit,
    nomesOnibus: List<String>
) {
    var nome by remember { mutableStateOf(passageiroInicial?.nome ?: "") 
}
    var cpf by remember { mutableStateOf(passageiroInicial?.cpf ?: "") 
}
    var rg by remember { mutableStateOf(passageiroInicial?.rg ?: "") 
}
    var onibusSelecionado by remember { mutableStateOf(passageiroInicial?.onibus ?: nomesOnibus.firstOrNull().orEmpty()) 
}
    var assento by remember { mutableStateOf(passageiroInicial?.assento ?: "") 
}
    var preco by remember { mutableStateOf(passageiroInicial?.preco ?: "") 
}
    var formaPagamento by remember { mutableStateOf(passageiroInicial?.formaPagamento ?: "À vista") 
}
    var statusPagamento by remember { mutableStateOf(passageiroInicial?.statusPagamento ?: "Pendente") 
}
    var menuOnibus by remember { mutableStateOf(false) 
}
    var menuForma by remember { mutableStateOf(false) 
}
    var menuStatus by remember { mutableStateOf(false) 
}
    var erro by remember { mutableStateOf("") 
}
    Dialog(onDismissRequest = onCancelar) 
{
        Surface(shape = RoundedCornerShape(18.dp), color = Color.White) 
{
            Column(
                Modifier.fillMaxWidth().heightIn(max = 700.dp).verticalScroll(rememberScrollState()).padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) 
{
                Text(if (passageiroInicial == null) "Novo passageiro" else "Editar passageiro", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Azul)
                Campo("Nome completo", nome) { nome = 
it }
                Campo("CPF", cpf) { cpf = 
it }
                Campo("RG", rg) { rg = 
it }
                if (nomesOnibus.isEmpty()) {
                    Text("Nenhum ônibus cadastrado. Você pode preencher a identificação do ônibus manualmente.")
                    Campo("Ônibus", onibusSelecionado) { onibusSelecionado = 
it }
                } else {
                    ExposedDropdownMenuBox(
                        expanded = menuOnibus,
                        onExpandedChange = { menuOnibus = !menuOnibus 
}
                    ) 
{
                        OutlinedTextField(
                            value = onibusSelecionado,
                            onValueChange = { onibusSelecionado = it },
                            label = { Text("Ônibus") },
                            modifier = Modifier.fillMaxWidth().menuAnchor(),
                            singleLine = 
true
                        )
                        ExposedDropdownMenu(expanded = menuOnibus, onDismissRequest = { menuOnibus = false }) 
{
                            nomesOnibus.forEach { nomeBus 
->
                                DropdownMenuItem(
                                    text = { Text(nomeBus) },
                                    onClick = { onibusSelecionado = nomeBus; menuOnibus = false 
}
                                )
                            
}
                        }
                    }
                }
                Campo("Assento", assento) { assento = 
it }
                Campo("Preço da viagem (ex.: 250.00)", preco) { preco = 
it }
                ExposedDropdownMenuBox(expanded = menuForma, onExpandedChange = { menuForma = !menuForma }) 
{
                    OutlinedTextField(
                        value = formaPagamento,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Forma de pagamento") },
                        modifier = Modifier.fillMaxWidth().menuAnchor(),
                        singleLine = 
true
                    )
                    ExposedDropdownMenu(expanded = menuForma, onDismissRequest = { menuForma = false }) 
{
                        listOf("À vista", "Parcelado").forEach 
{
                            DropdownMenuItem(text = { Text(it) }, onClick = { formaPagamento = it; menuForma = false })
                        
}
                    }
                }
                ExposedDropdownMenuBox(expanded = menuStatus, onExpandedChange = { menuStatus = !menuStatus }) 
{
                    OutlinedTextField(
                        value = statusPagamento,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Situação do pagamento") },
                        modifier = Modifier.fillMaxWidth().menuAnchor(),
                        singleLine = 
true
                    )
                    ExposedDropdownMenu(expanded = menuStatus, onDismissRequest = { menuStatus = false }) 
{
                        listOf("Pendente", "Pago", "Parcial").forEach 
{
                            DropdownMenuItem(text = { Text(it) }, onClick = { statusPagamento = it; menuStatus = false })
                        
}
                    }
                }
                if (erro.isNotBlank()) Text(erro, color = MaterialTheme.colorScheme.error)
                Button(
                    onClick = 
{
                        val valor = preco.replace(",", ".").toDoubleOrNull()
                        erro = when {
                            nome.isBlank() -> 
"Informe o nome completo."
                            valor == null || valor < 0 -> 
"Informe um preço válido, por exemplo 250.00."
                            else -> 
""
                        }
                        if (erro.isEmpty()) {
                            onSalvar(Passageiro(nome.trim(), cpf.trim(), rg.trim(), onibusSelecionado.trim(), assento.trim(),
                                String.format(java.util.Locale.US, "%.2f", valor), formaPagamento, statusPagamento))
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) { Text(if (passageiroInicial == null) "Cadastrar passageiro" else "Salvar alterações") 
}
                OutlinedButton(onClick = onCancelar, modifier = Modifier.fillMaxWidth()) { Text("Cancelar") 
}
            }
        }
    }
}
@Composable
fun Campo(titulo: String, valor: String, aoAlterar: (String) -> Unit) {
    OutlinedTextField(
        value = valor,
        onValueChange = aoAlterar,
        label = { Text(titulo) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = 
true
    )
}
@Composable
fun Titulo(texto: String) {
    Text(texto, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Azul, modifier = Modifier.padding(bottom = 12.dp))
}
@Composable
fun BotaoVoltar(aoClicar: () -> Unit) {
    Spacer(Modifier.height(8.dp))
    OutlinedButton(onClick = aoClicar, modifier = Modifier.fillMaxWidth()) { Text("Voltar") 
}
}
