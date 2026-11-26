package com.example.beta.dao

import androidx.room.*
import com.example.beta.model.*

@Dao
interface ViagemDao {

    // Consultar os dados salvos.
    @Query("SELECT * FROM viagens")
    suspend fun listarViagens(): List<Viagem>

    @Query("SELECT * FROM onibus")
    suspend fun listarOnibus(): List<Onibus>

    @Query("SELECT * FROM passageiros")
    suspend fun listarPassageiros(): List<Passageiro>

    @Query("SELECT * FROM reservas")
    suspend fun listarReservas(): List<Reserva>

    @Query("SELECT * FROM pagamentos")
    suspend fun listarPagamentos(): List<Pagamento>

    // Cadastrar os dados.
    @Insert
    suspend fun inserirViagem(viagem: Viagem)

    @Insert
    suspend fun inserirOnibus(onibus: Onibus)

    @Insert
    suspend fun inserirPassageiro(passageiro: Passageiro)

    @Insert
    suspend fun inserirReserva(reserva: Reserva)

    @Insert
    suspend fun inserirPagamento(pagamento: Pagamento)

    // Atualizar dados.
    @Update
    suspend fun atualizarPassageiro(passageiro: Passageiro)

    @Update
    suspend fun atualizarPagamento(pagamento: Pagamento)

    // Excluir dados.
    @Delete
    suspend fun excluirPassageiro(passageiro: Passageiro)

    @Delete
    suspend fun excluirReserva(reserva: Reserva)

    @Delete
    suspend fun excluirPagamento(pagamento: Pagamento)
}