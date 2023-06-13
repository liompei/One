package com.dawn.lib.wan

import com.dawn.lib.model.Article
import com.dawn.lib.model.FlowableArticle

sealed interface WanUiState {

    object Loading : WanUiState

    object LoadingFailed : WanUiState

    object NotShown : WanUiState

    data class Shown(
        val articles: List<FlowableArticle>
    ) : WanUiState


}
