package com.example.beta.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Onibus(
    val nome: String,
    val placa: String,
    val assentos: Int,
    val acessiveis: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
