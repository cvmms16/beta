
package com.example.beta.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "pagamentos",
    foreignKeys = [
        ForeignKey(
            entity = Reserva::class,
            parentColumns = ["id"],
            childColumns = ["reservaId"]
        )
    ],
    indices = [Index("reservaId")]
)
data class Pagamento(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val reservaId: Int,
    val valorTotal: Double,
    val valorPago: Double = 0.0,
    val formaPagamento: String,
    val status: String = "Pendente",
    val parcelas: Int = 1
) {
    val saldoRestante: Double
        get() = (valorTotal - valorPago).coerceAtLeast(0.0)
}

