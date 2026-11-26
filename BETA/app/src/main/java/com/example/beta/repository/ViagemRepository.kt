package com.example.beta.repository

import com.example.beta.dao.ViagemDao
import com.example.beta.model.*

class ViagemRepository(private val dao: ViagemDao) {

    // Buscar os dados.
    suspend fun listarViagens() = dao.listarViagens()

    suspend fun listarOnibus() = dao.listarOnibus()

    suspend fun listarPassageiros() = dao.listarPassageiros()

    suspend fun listarReservas() = dao.listarReservas()

    suspend fun listarPagamentos() = dao.listarPagamentos()

    // Cadastrar.
    suspend fun inserirViagem(viagem: Viagem) =
        dao.inserirViagem(viagem)

    suspend fun inserirOnibus(onibus: Onibus) =
        dao.inserirOnibus(onibus)

    suspend fun inserirPassageiro(passageiro: Passageiro) =
        dao.inserirPassageiro(passageiro)

    suspend fun inserirReserva(reserva: Reserva) =
        dao.inserirReserva(reserva)

    suspend fun inserirPagamento(pagamento: Pagamento) =
        dao.inserirPagamento(pagamento)

    // Atualizar.
    suspend fun atualizarPassageiro(passageiro: Passageiro) =
        dao.atualizarPassageiro(passageiro)

    suspend fun atualizarPagamento(pagamento: Pagamento) =
        dao.atualizarPagamento(pagamento)

    // Excluir.
    suspend fun excluirPassageiro(passageiro: Passageiro) =
        dao.excluirPassageiro(passageiro)

    suspend fun excluirReserva(reserva: Reserva) =
        dao.excluirReserva(reserva)

    suspend fun excluirPagamento(pagamento: Pagamento) =
        dao.excluirPagamento(pagamento)
}