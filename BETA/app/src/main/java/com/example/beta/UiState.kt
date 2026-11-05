package com.example.beta

sealed class UiState<out T> {
    data object Carregando : UiState<Nothing>()
    data object Vazio : UiState<Nothing>()
    data class Erro(val mensagem: String) : UiState<Nothing>()
    data class Sucesso<T>(val dados: T) : UiState<T>()
}
