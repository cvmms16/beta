package com.example.beta.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passageiros")
data class Passageiro(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val cpf: String,
    val rg: String
)