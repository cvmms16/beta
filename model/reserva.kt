
package com.example.beta.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "reservas",
    foreignKeys = [
        ForeignKey(
            entity = Passageiro::class,
            parentColumns = ["id"],
            childColumns = ["passageiroId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Viagem::class,
            parentColumns = ["id"],
            childColumns = ["onibusId"],
            onDelete = ForeignKey.CASCADE
        ),
       
    ],
    indices = [
        Index("passageiroId"),
        Index("onibusId")
    ]
)
data class Reserva(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val passageiroId: Int,
    val viagemId: Int,
    val onibusId: Int,
    val numeroAssento: Int,
    val status: String = "Reservado"
)
