package com.dawn.lib.data.repository

import com.dawn.lib.data.model.Topic
import kotlinx.coroutines.flow.Flow

interface TopicsRepository {

    fun getTopics():Flow<List<Topic>>

    fun getTopic(id:String):Flow<Topic>

}