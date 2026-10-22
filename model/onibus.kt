package com.example.beta.model

data class Onibus(
    val nome: String,
    val placa: String,
    val assentos: Int,
    val acessiveis: Int,
    val id: Int = 0
)