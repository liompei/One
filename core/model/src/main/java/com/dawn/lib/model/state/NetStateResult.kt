package com.dawn.lib.model.state

import com.dawn.lib.common.BuildConfig

/**
 * 网络请求结果封装
 * 统一请求结果的code，msg
 */
sealed class NetStateResult<out R> {
    data class Success<out T>(val data: T) : NetStateResult<T>()
    data class Failure(
        val errCode: Int,
        val errMessage: String?
    ) : NetStateResult<Nothing>() {
        override fun toString(): String {
            if (BuildConfig.DEBUG) {
                return "errCode:$errCode errMessage:$errMessage"
            } else {
                return "errMessage:$errMessage"
            }
        }
    }
}

fun NetStateResult.Failure.asUiStateError(): UiState.Error {
    return UiState.Error(this.errCode, this.errMessage)
}

fun <R> NetStateResult<R>.asUiState(): UiState<R> {
    return when (this) {
        is NetStateResult.Success -> {
            UiState.Success(data)
        }

        is NetStateResult.Failure -> {
            UiState.Error(errCode, errMessage)
        }
    }
}