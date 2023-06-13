package com.dawn.lib.domain

import com.dawn.lib.data.repository.WanArticleRepository
import com.dawn.lib.model.FlowableArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WanArticleUseCase constructor(
    private val wanArticleRepository: WanArticleRepository
) {

    operator fun invoke(): Flow<List<FlowableArticle>> {
        val wanArticleList = wanArticleRepository.getWanArticleList().map { articleList ->
            articleList.map { article ->
                FlowableArticle(
                    article = article,
                    isFollowed = false
                )
            }
        }
        return wanArticleList
    }

}