package com.example.beta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beta.ui.theme.BETATheme

// Modelo simples para representar uma Viagem
data class Viagem(
    val id: Int,
    val destino: String,
    val data: String,
    val assentosLivres: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BETATheme {
                BetaApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BetaApp() {
    // Lista fictícia para o esqueleto inicial
    val viagens = listOf(
        Viagem(1, "Recife -> Caruaru", "20/12/2026", 15),
        Viagem(2, "Caruaru -> Garanhuns", "21/12/2026", 8),
        Viagem(3, "Recife -> Petrolina", "22/12/2026", 2)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beta Turismo - Gestão") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.Black
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* F1: Cadastrar Viagem */ }) {
                Icon(Icons.Default.Add, contentDescription = "Nova Viagem")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Viagens Disponíveis",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn {
                items(viagens) { viagem ->
                    ViagemCard(viagem)
                }
            }
        }
    }
}

@Composable
fun ViagemCard(viagem: Viagem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = viagem.destino, style = MaterialTheme.typography.titleLarge)
            Text(text = "Data: ${viagem.data}")
            Text(text = "Assentos disponíveis: ${viagem.assentosLivres}")
            
            Button(
                onClick = { /* F2/F3: Selecionar assento / Reserva */ },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Ver Detalhes / Reservar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BETATheme {
        BetaApp()
    }
}
