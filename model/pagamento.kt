
package com.example.beta.model

data class Pagamento(
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
