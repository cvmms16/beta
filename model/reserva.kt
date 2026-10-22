package com.example.beta.model

data class Reservas(
    val id: Int = 0,
    val passageiroId: Int,
    val viagemId: Int,
    val onibusId: Int,
    val numeroAssento: Int,
    val status: String = "Reservado"
)