package com.dawn.lib.network.retrofit

import com.dawn.lib.common.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

abstract class RetrofitOneNetwork {

    private val json = Json { ignoreUnknownKeys = true }

    private val jsonFactory: Converter.Factory by lazy {
        json.asConverterFactory("application/json".toMediaType())
    }

    fun <S> getService(serviceClass: Class<S>, baseUrl: String): S {
        val okHttpBuilder = OkHttpClient.Builder()
        handleBuilder(okHttpBuilder)
        okHttpBuilder.addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    if (BuildConfig.DEBUG) {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    } else {
                        setLevel(HttpLoggingInterceptor.Level.BASIC)
                    }
                }
        )
        val builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .callFactory(okHttpBuilder.build())
            .addConverterFactory(jsonFactory)

        val retrofit = builder.build()
        return retrofit.create(serviceClass)
    }

    protected open fun handleBuilder(builder: OkHttpClient.Builder) {

    }

}