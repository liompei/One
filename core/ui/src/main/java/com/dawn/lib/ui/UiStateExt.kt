package com.dawn.lib.ui

import com.dawn.lib.model.state.UiState

inline fun <R> UiState<R>.onLoading(crossinline loading: () -> Unit): UiState<R> {
    if (this is UiState.Loading) {
        loading.invoke()
    }
    return this
}

inline fun <T> UiState<T>.onSuccess(crossinline success: (data: T?) -> Unit): UiState<T> {
    if (this is UiState.Success) {
        success.invoke(data)
    }
    return this
}

inline fun <R> UiState<R>.onError(
    crossinline error: (
        errCode: Int,
        errMessage: String?
    ) -> Unit
): UiState<R> {
    if (this is UiState.Error) {
        error.invoke(errCode, errMessage)
    }
    return this
}