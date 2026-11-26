package com.example.beta.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Representa uma viagem cadastrada.
// Existe para guardar as viagens no banco.
// Sem ela, as viagens não seriam armazenadas.
@Entity(tableName = "viagens")
data class Viagem(
    val nome: String,
    val origem: String,
    val destino: String,
    val ida: String,
    val volta: String,
    val preco: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)