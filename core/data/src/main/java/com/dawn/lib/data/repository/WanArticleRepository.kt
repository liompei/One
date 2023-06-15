package com.dawn.lib.data.repository

import com.dawn.lib.model.Article
import com.dawn.lib.model.state.NetStateResult
import kotlinx.coroutines.flow.Flow

interface WanArticleRepository : BaseRepository {

   suspend fun getWanArticleList(page: Int): NetStateResult<List<Article>>

}