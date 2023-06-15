package com.dawn.lib.data.repository.impl

import com.dawn.lib.data.repository.WanArticleRepository
import com.dawn.lib.model.Article
import com.dawn.lib.model.state.NetStateResult
import com.dawn.lib.network.wan.WanNetwork

class WanArticleRepositoryImpl : WanArticleRepository {

    override suspend fun getWanArticleList(page: Int): NetStateResult<List<Article>> {
        return safeCall {
            WanNetwork.getArticleList(page)
        }
    }

}