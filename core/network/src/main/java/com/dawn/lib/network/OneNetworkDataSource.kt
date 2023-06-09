package com.dawn.lib.network

import com.dawn.lib.network.model.NetworkChangeList
import com.dawn.lib.network.model.NetworkNewsResource
import com.dawn.lib.network.model.NetworkTopic

/**
 * 后端的网络调用的接口
 */
interface OneNetworkDataSource {

    suspend fun getTopic(ids: List<String>? = null): List<NetworkTopic>

    suspend fun getNewsResources(ids: List<String>? = null): List<NetworkNewsResource>

    suspend fun getTopicChangeList(after: Int? = null): List<NetworkChangeList>

    suspend fun getNewsResourceChangeList(after: Int? = null): List<NetworkChangeList>

}