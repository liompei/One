package com.dawn.lib.wan

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.dawn.lib.data.repository.impl.WanArticleRepositoryImpl
import com.dawn.lib.domain.WanArticleUseCase
import com.dawn.lib.model.Article
import com.dawn.lib.model.state.UiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class WanViewModel constructor(
    private val wanArticleUseCase: WanArticleUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        Log.d("aaaaaaaaaa", "init")
    }

    val onWanArticleUiState: StateFlow<UiState<List<Article>>> =
        wanArticleUseCase.invoke()
//            .map {
//                Log.d("aaaaaaaaaa", "aaa")
//                it
//            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Loading
            )

    companion object {

        val Factory = viewModelFactory {
            initializer {
//                val repo = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                val savedStateHandle = createSavedStateHandle()
                WanViewModel(
                    wanArticleUseCase = WanArticleUseCase(WanArticleRepositoryImpl()),
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }

}