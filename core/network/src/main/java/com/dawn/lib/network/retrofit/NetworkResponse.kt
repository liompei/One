package com.dawn.lib.network.retrofit

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<T>(
    val data: T,
    val errorCode: Int,
    val errorMsg: String
)
