package com.example.beta.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.beta.R
import com.example.beta.UiState
import com.example.beta.data.AppDatabase
import com.example.beta.model.*
import com.example.beta.repository.ViagemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class ViagemViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).viagemDao()
    private val repository = ViagemRepository(dao)

    // Estados das listas.
    private val _viagensState =
        MutableStateFlow<UiState<List<Viagem>>>(UiState.Carregando)

    val viagensState = _viagensState.asStateFlow()

    private val _onibusState =
        MutableStateFlow<UiState<List<Onibus>>>(UiState.Carregando)

    val onibusState = _onibusState.asStateFlow()

    private val _passageirosState =
        MutableStateFlow<UiState<List<Passageiro>>>(UiState.Carregando)

    val passageirosState = _passageirosState.asStateFlow()

    private val _reservasState =
        MutableStateFlow<UiState<List<Reserva>>>(UiState.Carregando)

    val reservasState = _reservasState.asStateFlow()

    private val _pagamentosState =
        MutableStateFlow<UiState<List<Pagamento>>>(UiState.Carregando)

    val pagamentosState = _pagamentosState.asStateFlow()

    init {
        carregar()
    }

    // Busca os dados no banco.
    fun carregar() {

        viewModelScope.launch {

            definirCarregando()

            try {

                val viagens = repository.listarViagens()
                val onibus = repository.listarOnibus()
                val passageiros = repository.listarPassageiros()
                val reservas = repository.listarReservas()
                val pagamentos = repository.listarPagamentos()

                _viagensState.value =
                    if (viagens.isEmpty()) UiState.Vazio
                    else UiState.Sucesso(viagens)

                _onibusState.value =
                    if (onibus.isEmpty()) UiState.Vazio
                    else UiState.Sucesso(onibus)

                _passageirosState.value =
                    if (passageiros.isEmpty()) UiState.Vazio
                    else UiState.Sucesso(passageiros)

                _reservasState.value =
                    if (reservas.isEmpty()) UiState.Vazio
                    else UiState.Sucesso(reservas)

                _pagamentosState.value =
                    if (pagamentos.isEmpty()) UiState.Vazio
                    else UiState.Sucesso(pagamentos)

            } catch (e: IOException) {

                mostrarErro(
                    getApplication<Application>()
                        .getString(R.string.erro_conexao)
                )

            } catch (e: Exception) {

                mostrarErro(
                    getApplication<Application>()
                        .getString(R.string.erro_generico)
                )
            }
        }
    }

    // Coloca todas as listas no estado de carregamento.
    private fun definirCarregando() {

        _viagensState.value = UiState.Carregando
        _onibusState.value = UiState.Carregando
        _passageirosState.value = UiState.Carregando
        _reservasState.value = UiState.Carregando
        _pagamentosState.value = UiState.Carregando
    }

    // Mostra a mensagem de erro.
    private fun mostrarErro(mensagem: String) {

        _viagensState.value = UiState.Erro(mensagem)
        _onibusState.value = UiState.Erro(mensagem)
        _passageirosState.value = UiState.Erro(mensagem)
        _reservasState.value = UiState.Erro(mensagem)
        _pagamentosState.value = UiState.Erro(mensagem)
    }

    // Executa uma operação e atualiza as listas.
    private fun executarOperacao(operacao: suspend () -> Unit) {

        viewModelScope.launch {

            try {

                operacao()
                carregar()

            } catch (e: IOException) {

                mostrarErro(
                    getApplication<Application>()
                        .getString(R.string.erro_conexao)
                )

            } catch (e: Exception) {

                mostrarErro(
                    getApplication<Application>()
                        .getString(R.string.erro_generico)
                )
            }
        }
    }

    // Viagens.
    fun salvarViagem(viagem: Viagem) {
        executarOperacao {
            repository.inserirViagem(viagem)
        }
    }

    // Ônibus.
    fun salvarOnibus(onibus: Onibus) {
        executarOperacao {
            repository.inserirOnibus(onibus)
        }
    }

    // Passageiros.
    fun salvarPassageiro(passageiro: Passageiro) {
        executarOperacao {
            repository.inserirPassageiro(passageiro)
        }
    }

    fun atualizarPassageiro(passageiro: Passageiro) {
        executarOperacao {
            repository.atualizarPassageiro(passageiro)
        }
    }

    fun excluirPassageiro(passageiro: Passageiro) {
        executarOperacao {
            repository.excluirPassageiro(passageiro)
        }
    }

    // Reservas.
    fun salvarReserva(reserva: Reserva) {
        executarOperacao {
            repository.inserirReserva(reserva)
        }
    }

    fun excluirReserva(reserva: Reserva) {
        executarOperacao {
            repository.excluirReserva(reserva)
        }
    }

    // Pagamentos.
    fun salvarPagamento(pagamento: Pagamento) {
        executarOperacao {
            repository.inserirPagamento(pagamento)
        }
    }

    fun atualizarPagamento(pagamento: Pagamento) {
        executarOperacao {
            repository.atualizarPagamento(pagamento)
        }
    }

    fun excluirPagamento(pagamento: Pagamento) {
        executarOperacao {
            repository.excluirPagamento(pagamento)
        }
    }
}