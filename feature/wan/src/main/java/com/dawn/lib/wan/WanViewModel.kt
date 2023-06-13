package com.dawn.lib.wan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.lib.domain.WanArticleUseCase
import com.dawn.lib.model.FlowableArticle
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class WanViewModel constructor(
    private val wanArticleUseCase: WanArticleUseCase
) : ViewModel() {

    val onWanArticleUiState: StateFlow<WanUiState> =
        wanArticleUseCase.invoke()
            .map {
                WanUiState.Shown(articles = it)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = WanUiState.Loading
            )

}