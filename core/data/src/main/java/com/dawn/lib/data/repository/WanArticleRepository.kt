package com.dawn.lib.data.repository

import com.dawn.lib.model.Article
import kotlinx.coroutines.flow.Flow

interface WanArticleRepository {

    fun getWanArticleList(): Flow<List<Article>>

}