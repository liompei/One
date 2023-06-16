package com.dawn.lib.data.repository

import com.dawn.lib.model.Article
import com.dawn.lib.model.state.NetStateResult

interface WanArticleRepository : BaseRepository {

   suspend fun getWanArticleList(page: Int): NetStateResult<Article>

}