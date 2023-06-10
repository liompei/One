package com.dawn.lib.data.repository

import com.dawn.lib.data.model.Topic
import com.dawn.lib.network.OneNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OfflineFirstTopicsRepository constructor(
    private val network: OneNetworkDataSource
) : TopicsRepository {
    override fun getTopics(): Flow<List<Topic>> {
       return flow {
           network.getTopic(listOf())
       }
    }

    override fun getTopic(id: String): Flow<Topic> {
        TODO("Not yet implemented")
    }


}