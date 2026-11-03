package com.example.beta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.beta.model.Onibus
import com.example.beta.model.Pagamento
import com.example.beta.model.Passageiro
import com.example.beta.model.Reservas
import com.example.beta.model.Viagem
import java.util.Locale

private val Azul = Color(0xFF174A7E)
private val AzulClaro = Color(0xFF4D8FC7)
private val Amarelo = Color(0xFFFFC928)
private val Fundo = Color(0xFFF2F7FC)
private val Texto = Color(0xFF172B3A)
private val Cinza = Color(0xFF657586)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme(
                primary = Azul, secondary = AzulClaro, tertiary = Amarelo,
                background = Fundo, surface = Color.White, onPrimary = Color.White,
                onBackground = Texto, onSurface = Texto
            )) { BetaTurismo() }
        }
    }
}

@Composable
fun BetaTurismo() {
    val viagens = remember { mutableStateListOf<Viagem>() }
    val onibus = remember { mutableStateListOf<Onibus>() }
    val passageiros = remember { mutableStateListOf<Passageiro>() }
    val reservas = remember { mutableStateListOf<Reservas>() }
    val pagamentos = remember { mutableStateListOf<Pagamento>() }

    var tela by remember { mutableStateOf("inicio") }
    var menuAberto by remember { mutableStateOf(false) }
    var viagemSelecionadaId by remember { mutableIntStateOf(0) }
    var mostrarPassageiro by remember { mutableStateOf(false) }
    var mostrarReserva by remember { mutableStateOf(false) }
    var mostrarPagamento by remember { mutableStateOf(false) }
    var passageiroEditando by remember { mutableIntStateOf(0) }
    var busca by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Scaffold(
        containerColor = Fundo,
        topBar = { Surface(color = Azul) {
            Column(Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Beta Turismo", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Text("Gestão de viagens", color = Color.White)
            }
        } },
        floatingActionButton = {
            if (tela == "inicio") Box {
                FloatingActionButton(onClick = { menuAberto = true }, containerColor = Amarelo, contentColor = Texto) { Text("+", fontSize = 28.sp) }
                DropdownMenu(expanded = menuAberto, onDismissRequest = { menuAberto = false }) {
                    DropdownMenuItem(text = { Text("Adicionar viagem") }, onClick = { menuAberto = false; tela = "novaViagem" })
                    DropdownMenuItem(text = { Text("Adicionar ônibus") }, onClick = { menuAberto = false; tela = "novoOnibus" })
                    DropdownMenuItem(text = { Text("Passageiros") }, onClick = { menuAberto = false; tela = "passageiros" })
                    DropdownMenuItem(text = { Text("Reservas") }, onClick = { menuAberto = false; tela = "reservas" })
                    DropdownMenuItem(text = { Text("Pagamentos") }, onClick = { menuAberto = false; tela = "pagamentos" })
                }
            }
        }
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            when (tela) {
                "inicio" -> {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Titulo("Viagens cadastradas")
                        TextButton(onClick = { tela = "frota" }) { Text("Frota") }
                    }
                    if (viagens.isEmpty()) Text("Você ainda não cadastrou nenhuma viagem.", color = Cinza)
                    else LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(viagens) { viagem ->
                            Card(Modifier.fillMaxWidth()) { Column(Modifier.padding(14.dp)) {
                                Text("${viagem.origem} → ${viagem.destino}", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Azul)
                                Text("${viagem.nome} • Ida: ${viagem.ida} • Volta: ${viagem.volta}")
                                Text("Preço por passageiro: R$ ${viagem.preco}")
                                Button(onClick = { viagemSelecionadaId = viagens.indexOf(viagem) + 1; tela = "detalhes" }, modifier = Modifier.fillMaxWidth()) { Text("Ver detalhes") }
                            } }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { tela = "reservas" }, modifier = Modifier.fillMaxWidth()) { Text("Gerenciar reservas") }
                    Spacer(Modifier.height(6.dp))
                    OutlinedButton(onClick = { tela = "pagamentos" }, modifier = Modifier.fillMaxWidth()) { Text("Gerenciar pagamentos") }
                }
                "novaViagem" -> FormularioViagem({ tela = "inicio" }) { viagens.add(it); tela = "inicio" }
                "novoOnibus" -> FormularioOnibus({ tela = "inicio" }) { onibus.add(it); tela = "frota" }
                "detalhes" -> {
                    val viagem = viagens.getOrNull(viagemSelecionadaId - 1)
                    Titulo(viagem?.nome ?: "Detalhes da viagem")
                    if (viagem != null) {
                        Text("${viagem.origem} → ${viagem.destino}")
                        Text("Ida: ${viagem.ida} | Volta: ${viagem.volta}")
                        Text("Preço: R$ ${viagem.preco}")
                    }
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = { tela = "reservas" }, modifier = Modifier.fillMaxWidth()) { Text("Reservas e assentos") }
                    OutlinedButton(onClick = { tela = "pagamentos" }, modifier = Modifier.fillMaxWidth()) { Text("Pagamentos") }
                    BotaoVoltar { tela = "inicio" }
                }
                "frota" -> {
                    Titulo("Frota de ônibus")
                    if (onibus.isEmpty()) Text("Nenhum ônibus cadastrado.")
                    else LazyColumn(Modifier.weight(1f)) { items(onibus) { bus -> Card(Modifier.fillMaxWidth().padding(bottom = 8.dp)) { Column(Modifier.padding(12.dp)) {
                        Text(bus.nome, fontWeight = FontWeight.Bold); Text("Placa: ${bus.placa.ifBlank { "Não informada" }}")
                        Text("Assentos: ${bus.assentos} • Acessíveis: ${bus.acessiveis}")
                    } } } }
                    BotaoVoltar { tela = "inicio" }
                }
                "passageiros" -> {
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Titulo("Passageiros"); Button(onClick = { passageiroEditando = 0; mostrarPassageiro = true }) { Text("+ Adicionar") }
                    }
                    OutlinedTextField(busca, { busca = it }, label = { Text("Buscar por nome ou CPF") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
                    val filtrados = passageiros.filter { it.nome.contains(busca, true) || it.cpf.contains(busca, true) }
                    if (filtrados.isEmpty()) Text("Nenhum passageiro encontrado.", color = Cinza)
                    else LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(filtrados) { p -> Card(Modifier.fillMaxWidth()) { Column(Modifier.padding(12.dp)) {
                            Text(p.nome, fontWeight = FontWeight.Bold, color = Azul); Text("CPF: ${p.cpf} • RG: ${p.rg}")
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                OutlinedButton(onClick = { passageiroEditando = p.id; mostrarPassageiro = true }, modifier = Modifier.weight(1f)) { Text("Editar") }
                                OutlinedButton(onClick = { reservas.filter { it.passageiroId == p.id }.forEach { r -> pagamentos.removeAll { it.reservaId == r.id }; reservas.remove(r) }; passageiros.remove(p) }, modifier = Modifier.weight(1f)) { Text("Excluir") }
                            }
                        } } }
                    }
                    BotaoVoltar { tela = "inicio" }
                }
                "reservas" -> {
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Titulo("Reservas"); Button(onClick = { mensagem = ""; mostrarReserva = true }) { Text("+ Nova") }
                    }
                    if (reservas.isEmpty()) Text("Nenhuma reserva cadastrada. Cadastre passageiros, viagens e ônibus primeiro.", color = Cinza)
                    else LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(reservas) { r ->
                            val p = passageiros.find { it.id == r.passageiroId }
                            val v = viagens.getOrNull(r.viagemId - 1)
                            val b = onibus.getOrNull(r.onibusId - 1)
                            Card(Modifier.fillMaxWidth()) { Column(Modifier.padding(12.dp)) {
                                Text("Reserva #${r.id} • ${r.status}", fontWeight = FontWeight.Bold, color = Azul)
                                Text("Passageiro: ${p?.nome ?: "Não encontrado"}")
                                Text("Viagem: ${v?.let { "${it.origem} → ${it.destino}" } ?: "Não encontrada"}")
                                Text("Ônibus: ${b?.nome ?: "Não encontrado"} • Assento: ${r.numeroAssento}")
                                OutlinedButton(onClick = { reservas.remove(r); pagamentos.removeAll { it.reservaId == r.id } }, modifier = Modifier.fillMaxWidth()) { Text("Cancelar reserva") }
                            } }
                        }
                    }
                    if (mensagem.isNotBlank()) Text(mensagem, color = MaterialTheme.colorScheme.error)
                    BotaoVoltar { tela = "inicio" }
                }
                "pagamentos" -> {
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Titulo("Pagamentos"); Button(onClick = { mensagem = ""; mostrarPagamento = true }) { Text("+ Registrar") }
                    }
                    if (pagamentos.isEmpty()) Text("Nenhum pagamento registrado. Crie uma reserva primeiro.", color = Cinza)
                    else LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(pagamentos) { pg ->
                            val reserva = reservas.find { it.id == pg.reservaId }
                            val passageiro = reserva?.let { r -> passageiros.find { it.id == r.passageiroId } }
                            Card(Modifier.fillMaxWidth()) { Column(Modifier.padding(12.dp)) {
                                Text("Pagamento • ${passageiro?.nome ?: "Reserva #${pg.reservaId}"}", fontWeight = FontWeight.Bold, color = Azul)
                                Text("Status: ${pg.status} • Forma: ${pg.formaPagamento}")
                                Text("Total: ${moeda(pg.valorTotal)} • Pago: ${moeda(pg.valorPago)}")
                                Text("Saldo restante: ${moeda(pg.saldoRestante)} • Parcelas: ${pg.parcelas}")
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Button(onClick = {
                                        val atualizado = pg.copy(valorPago = pg.valorTotal, status = "Pago")
                                        pagamentos[ pagamentos.indexOf(pg) ] = atualizado
                                    }, modifier = Modifier.weight(1f), enabled = pg.valorPago < pg.valorTotal) { Text("Quitar saldo") }
                                    OutlinedButton(onClick = { pagamentos.remove(pg) }, modifier = Modifier.weight(1f)) { Text("Excluir") }
                                }
                            } }
                        }
                    }
                    if (mensagem.isNotBlank()) Text(mensagem, color = MaterialTheme.colorScheme.error)
                    BotaoVoltar { tela = "inicio" }
                }
            }
        }
    }

    if (mostrarPassageiro) {
        val atual = passageiros.find { it.id == passageiroEditando }
        FormularioPassageiro(atual, { mostrarPassageiro = false }) { novo ->
            if (atual == null) passageiros.add(novo.copy(id = (passageiros.maxOfOrNull { it.id } ?: 0) + 1))
            else { val i = passageiros.indexOfFirst { it.id == atual.id }; if (i >= 0) passageiros[i] = novo.copy(id = atual.id) }
            mostrarPassageiro = false
        }
    }
    if (mostrarReserva) {
        FormularioReserva(passageiros.toList(), viagens.toList(), onibus.toList(), reservas.toList(),
            onCancelar = { mostrarReserva = false },
            onSalvar = { passageiroId, viagemId, onibusId, assento ->
                val id = (reservas.maxOfOrNull { it.id } ?: 0) + 1
                reservas.add(Reservas(id, passageiroId, viagemId, onibusId, assento, "Reservado"))
                mostrarReserva = false
            }, onErro = { mensagem = it })
    }
    if (mostrarPagamento) {
        FormularioPagamento(reservas.toList(), pagamentos.toList(), viagens.toList(),
            onCancelar = { mostrarPagamento = false },
            onSalvar = { reservaId, total, pago, forma, parcelas ->
                val status = when { pago >= total -> "Pago"; pago > 0 -> "Parcial"; else -> "Pendente" }
                pagamentos.add(Pagamento((pagamentos.maxOfOrNull { it.id } ?: 0) + 1, reservaId, total, pago, forma, status, parcelas))
                mostrarPagamento = false
            }, onErro = { mensagem = it })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormularioReserva(passageiros: List<Passageiro>, viagens: List<Viagem>, onibus: List<Onibus>, reservas: List<Reservas>, onCancelar: () -> Unit, onSalvar: (Int, Int, Int, Int) -> Unit, onErro: (String) -> Unit) {
    var pId by remember { mutableIntStateOf(passageiros.firstOrNull()?.id ?: 0) }
    var vId by remember { mutableIntStateOf(if (viagens.isNotEmpty()) 1 else 0) }
    var bId by remember { mutableIntStateOf(if (onibus.isNotEmpty()) 1 else 0) }
    var assento by remember { mutableStateOf("1") }
    var menuP by remember { mutableStateOf(false) }; var menuV by remember { mutableStateOf(false) }; var menuB by remember { mutableStateOf(false) }
    Dialog(onDismissRequest = onCancelar) { Surface(shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), color = Color.White) {
        Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Titulo("Nova reserva")
            if (passageiros.isEmpty() || viagens.isEmpty() || onibus.isEmpty()) Text("Antes de reservar, cadastre pelo menos um passageiro, uma viagem e um ônibus.", color = MaterialTheme.colorScheme.error)
            DropdownEscolha("Passageiro", passageiros.map { it.id to it.nome }, pId, { pId = it }, menuP, { menuP = it })
            DropdownEscolha("Viagem", viagens.mapIndexed { i, v -> (i + 1) to "${v.origem} → ${v.destino}" }, vId, { vId = it }, menuV, { menuV = it })
            DropdownEscolha("Ônibus", onibus.mapIndexed { i, b -> (i + 1) to b.nome }, bId, { bId = it }, menuB, { menuB = it })
            Campo("Número do assento", assento) { assento = it }
            val maxAssentos = onibus.getOrNull(bId - 1)?.assentos ?: 0
            val numero = assento.toIntOrNull()
            Button(onClick = {
                val erro = when {
                    passageiros.isEmpty() || viagens.isEmpty() || onibus.isEmpty() -> "Cadastre passageiro, viagem e ônibus antes de reservar."
                    numero == null || numero < 1 || numero > maxAssentos -> "Informe um assento entre 1 e $maxAssentos."
                    reservas.any { it.viagemId == vId && it.onibusId == bId && it.numeroAssento == numero && it.status != "Cancelado" } -> "Esse assento já está reservado para essa viagem."
                    else -> ""
                }
                if (erro.isNotBlank()) onErro(erro) else onSalvar(pId, vId, bId, numero!!)
            }, modifier = Modifier.fillMaxWidth(), enabled = passageiros.isNotEmpty() && viagens.isNotEmpty() && onibus.isNotEmpty()) { Text("Salvar reserva") }
            OutlinedButton(onClick = onCancelar, Modifier.fillMaxWidth()) { Text("Cancelar") }
        }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormularioPagamento(reservas: List<Reservas>, pagamentos: List<Pagamento>, viagens: List<Viagem>, onCancelar: () -> Unit, onSalvar: (Int, Double, Double, String, Int) -> Unit, onErro: (String) -> Unit) {
    var reservaId by remember { mutableIntStateOf(reservas.firstOrNull()?.id ?: 0) }
    var totalTexto by remember { mutableStateOf("") }; var pagoTexto by remember { mutableStateOf("0") }
    var forma by remember { mutableStateOf("À vista") }; var parcelasTexto by remember { mutableStateOf("1") }
    var menuR by remember { mutableStateOf(false) }; var menuF by remember { mutableStateOf(false) }
    Dialog(onDismissRequest = onCancelar) { Surface(shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), color = Color.White) {
        Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Titulo("Registrar pagamento")
            if (reservas.isEmpty()) Text("Cadastre uma reserva antes de registrar pagamento.", color = MaterialTheme.colorScheme.error)
            DropdownEscolha("Reserva", reservas.map { it.id to "Reserva #${it.id} (passageiro ID ${it.passageiroId})" }, reservaId, { reservaId = it }, menuR, { menuR = it })
            val reserva = reservas.find { it.id == reservaId }
            val precoViagem = reserva?.let { viagens.getOrNull(it.viagemId - 1)?.preco?.replace(",", ".")?.toDoubleOrNull() }
            OutlinedButton(onClick = { if (precoViagem != null) totalTexto = String.format(Locale.US, "%.2f", precoViagem) }, modifier = Modifier.fillMaxWidth()) { Text("Usar preço da viagem") }
            Campo("Valor total (ex.: 250.00)", totalTexto) { totalTexto = it }
            Campo("Valor já pago", pagoTexto) { pagoTexto = it }
            ExposedDropdownMenuBox(expanded = menuF, onExpandedChange = { menuF = !menuF }) {
                OutlinedTextField(forma, {}, readOnly = true, label = { Text("Forma de pagamento") }, modifier = Modifier.fillMaxWidth().menuAnchor())
                ExposedDropdownMenu(expanded = menuF, onDismissRequest = { menuF = false }) { listOf("À vista", "Pix", "Dinheiro", "Cartão", "Parcelado", "Transferência").forEach { op -> DropdownMenuItem(text = { Text(op) }, onClick = { forma = op; menuF = false }) } }
            }
            Campo("Quantidade de parcelas", parcelasTexto) { parcelasTexto = it }
            Button(onClick = {
                val total = totalTexto.replace(",", ".").toDoubleOrNull(); val pago = pagoTexto.replace(",", ".").toDoubleOrNull(); val parcelas = parcelasTexto.toIntOrNull()
                val erro = when { reservas.isEmpty() -> "Cadastre uma reserva primeiro."; total == null || total <= 0 -> "Informe um valor total válido."; pago == null || pago < 0 || pago > total -> "O valor pago deve ficar entre zero e o valor total."; parcelas == null || parcelas < 1 -> "Informe pelo menos uma parcela."; pagamentos.any { it.reservaId == reservaId } -> "Essa reserva já possui um pagamento registrado. Use o pagamento existente."; else -> "" }
                if (erro.isNotBlank()) onErro(erro) else onSalvar(reservaId, total!!, pago!!, forma, parcelas!!)
            }, modifier = Modifier.fillMaxWidth(), enabled = reservas.isNotEmpty()) { Text("Salvar pagamento") }
            OutlinedButton(onClick = onCancelar, Modifier.fillMaxWidth()) { Text("Cancelar") }
        }
    } }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DropdownEscolha(titulo: String, opcoes: List<Pair<Int, String>>, selecionado: Int, aoSelecionar: (Int) -> Unit, expandido: Boolean, aoExpandir: (Boolean) -> Unit) {
    val label = opcoes.firstOrNull { it.first == selecionado }?.second ?: "Selecione"
    ExposedDropdownMenuBox(expanded = expandido, onExpandedChange = aoExpandir) {
        OutlinedTextField(value = label, onValueChange = {}, readOnly = true, label = { Text(titulo) }, modifier = Modifier.fillMaxWidth().menuAnchor())
        ExposedDropdownMenu(expanded = expandido, onDismissRequest = { aoExpandir(false) }) {
            opcoes.forEach { (id, texto) -> DropdownMenuItem(text = { Text(texto) }, onClick = { aoSelecionar(id); aoExpandir(false) }) }
        }
    }
}

@Composable
private fun FormularioViagem(onCancelar: () -> Unit, onSalvar: (Viagem) -> Unit) {
    var nome by remember { mutableStateOf("") }; var origem by remember { mutableStateOf("") }; var destino by remember { mutableStateOf("") }
    var ida by remember { mutableStateOf("") }; var volta by remember { mutableStateOf("") }; var preco by remember { mutableStateOf("") }; var erro by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Titulo("Cadastrar viagem"); Campo("Nome da viagem", nome) { nome = it }; Campo("Cidade de origem", origem) { origem = it }; Campo("Cidade de destino", destino) { destino = it }
        Campo("Data de ida", ida) { ida = it }; Campo("Data de volta", volta) { volta = it }; Campo("Preço por passageiro", preco) { preco = it }
        if (erro.isNotBlank()) Text(erro, color = MaterialTheme.colorScheme.error)
        Button(onClick = { val valor = preco.replace(",", ".").toDoubleOrNull(); erro = when { nome.isBlank() || origem.isBlank() || destino.isBlank() || ida.isBlank() || volta.isBlank() -> "Preencha todos os campos."; valor == null || valor < 0 -> "Informe um preço válido."; else -> "" }; if (erro.isEmpty() && valor != null) onSalvar(Viagem(nome.trim(), origem.trim(), destino.trim(), ida.trim(), volta.trim(), String.format(Locale.US, "%.2f", valor))) }, modifier = Modifier.fillMaxWidth()) { Text("Cadastrar viagem") }
        BotaoVoltar(onCancelar)
    }
}

@Composable
private fun FormularioOnibus(onCancelar: () -> Unit, onSalvar: (Onibus) -> Unit) {
    var nome by remember { mutableStateOf("") }; var placa by remember { mutableStateOf("") }; var assentos by remember { mutableStateOf("") }; var acessiveis by remember { mutableStateOf("0") }; var erro by remember { mutableStateOf("") }
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Titulo("Cadastrar ônibus"); Campo("Nome ou identificação", nome) { nome = it }; Campo("Placa (opcional)", placa) { placa = it }; Campo("Quantidade de assentos", assentos) { assentos = it }; Campo("Espaços acessíveis", acessiveis) { acessiveis = it }
        if (erro.isNotBlank()) Text(erro, color = MaterialTheme.colorScheme.error)
        Button(onClick = { val total = assentos.toIntOrNull(); val acess = acessiveis.toIntOrNull(); erro = if (nome.isBlank() || total == null || total < 1 || acess == null || acess < 0 || acess > total) "Informe dados e quantidades válidas." else ""; if (erro.isEmpty() && total != null && acess != null) onSalvar(Onibus(nome.trim(), placa.trim(), total, acess)) }, modifier = Modifier.fillMaxWidth()) { Text("Cadastrar ônibus") }
        BotaoVoltar(onCancelar)
    }
}

@Composable
private fun FormularioPassageiro(inicial: Passageiro?, onCancelar: () -> Unit, onSalvar: (Passageiro) -> Unit) {
    var nome by remember { mutableStateOf(inicial?.nome ?: "") }; var cpf by remember { mutableStateOf(inicial?.cpf ?: "") }; var rg by remember { mutableStateOf(inicial?.rg ?: "") }; var erro by remember { mutableStateOf("") }
    Dialog(onDismissRequest = onCancelar) { Surface(shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp), color = Color.White) {
        Column(Modifier.fillMaxWidth().padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Titulo(if (inicial == null) "Novo passageiro" else "Editar passageiro"); Campo("Nome completo", nome) { nome = it }; Campo("CPF", cpf) { cpf = it }; Campo("RG", rg) { rg = it }
            if (erro.isNotBlank()) Text(erro, color = MaterialTheme.colorScheme.error)
            Button(onClick = { erro = if (nome.isBlank()) "Informe o nome completo." else ""; if (erro.isEmpty()) onSalvar(Passageiro(inicial?.id ?: 0, nome.trim(), cpf.trim(), rg.trim())) }, modifier = Modifier.fillMaxWidth()) { Text("Salvar passageiro") }
            OutlinedButton(onClick = onCancelar, Modifier.fillMaxWidth()) { Text("Cancelar") }
        }
    } }
}

@Composable
private fun Campo(titulo: String, valor: String, aoAlterar: (String) -> Unit) {
    OutlinedTextField(value = valor, onValueChange = aoAlterar, label = { Text(titulo) }, modifier = Modifier.fillMaxWidth(), singleLine = true)
}

@Composable
private fun Titulo(texto: String) {
    Text(texto, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Azul, modifier = Modifier.padding(bottom = 10.dp))
}

@Composable
private fun BotaoVoltar(aoClicar: () -> Unit) {
    Spacer(Modifier.height(8.dp)); OutlinedButton(onClick = aoClicar, modifier = Modifier.fillMaxWidth()) { Text("Voltar") }
}

private fun moeda(valor: Double): String = "R$ " + String.format(Locale("pt", "BR"), "%.2f", valor)
