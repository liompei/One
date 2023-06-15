package com.dawn.lib.domain

import android.util.Log
import com.dawn.lib.data.repository.WanArticleRepository
import com.dawn.lib.model.Article
import com.dawn.lib.model.state.UiState
import com.dawn.lib.model.state.asUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WanArticleUseCase constructor(
    private val wanArticleRepository: WanArticleRepository
) {

    operator fun invoke(page: Int = 0): Flow<UiState<List<Article>>> {
        return flow {
            emit(wanArticleRepository.getWanArticleList(page).asUiState())
        }
    }

}