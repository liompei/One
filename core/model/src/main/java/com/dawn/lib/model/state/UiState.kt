package com.dawn.lib.model.state

sealed interface UiState<out R> {

    object Loading : UiState<Nothing>

    data class Success<out T>(val data: T?) : UiState<T>

    data class Error(
        val errCode: Int,
        val errMessage: String?
    ) : UiState<Nothing>
}