package com.dawn.lib.network.retrofit

import com.dawn.lib.network.OneNetworkDataSource
import com.dawn.lib.network.model.NetworkChangeList
import com.dawn.lib.network.model.NetworkNewsResource
import com.dawn.lib.network.model.NetworkTopic
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private interface RetrofitOneNetworkApi {

    @GET("topics")
    suspend fun getTopics(@Query("id") ids: List<String>?): NetworkResponse<List<NetworkTopic>>

    @GET("newsresources")
    suspend fun getNewsResources(@Query("id") ids: List<String>?): NetworkResponse<List<NetworkNewsResource>>

    @GET("changelists/topics")
    suspend fun getTopicChangeList(@Query("after") after: Int?): List<NetworkChangeList>

    @GET("changelists/newsresources")
    suspend fun getNewsResourcesChangeList(@Query("after") after: Int?): List<NetworkChangeList>

}

private const val OneBaseUrl = "http://example.com"

@Serializable
private data class NetworkResponse<T>(
    val data: T
)

class RetrofitNiaNetwork constructor(
    networkJson: Json,
    okhttpCallFactory: Call.Factory
) : OneNetworkDataSource {


    private val networkApi = Retrofit.Builder()
        .baseUrl(OneBaseUrl)
        .callFactory(okhttpCallFactory)
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(RetrofitOneNetworkApi::class.java)


    override suspend fun getTopic(ids: List<String>?): List<NetworkTopic> {
        return networkApi.getTopics(ids).data
    }

    override suspend fun getNewsResources(ids: List<String>?): List<NetworkNewsResource> {
        return networkApi.getNewsResources(ids).data
    }

    override suspend fun getTopicChangeList(after: Int?): List<NetworkChangeList> {
        return networkApi.getTopicChangeList(after)
    }

    override suspend fun getNewsResourceChangeList(after: Int?): List<NetworkChangeList> {
        return networkApi.getNewsResourcesChangeList(after)
    }


}