package com.dawn.lib.wan

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alibaba.android.arouter.facade.annotation.Route
import com.dawn.lib.model.state.UiState
import com.dawn.lib.ui.launchAndCollectIn
import com.dawn.lib.ui.onError
import com.dawn.lib.ui.onLoading
import com.dawn.lib.ui.onSuccess
import com.dawn.lib.wan.databinding.WanActivityWanBinding
import com.google.android.material.navigation.NavigationBarView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch

@Route(path = "/wan/activity/WanActivity")
class WanActivity : AppCompatActivity() {

    private lateinit var binding: WanActivityWanBinding
    private val viewModel by viewModels<WanViewModel> { WanViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WanActivityWanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_article -> {
                    Log.d("aaaaaa", "aaaa")
                }
            }
            return@setOnItemSelectedListener true
        }
        viewModel.onWanArticleUiState
            .launchAndCollectIn(this) {
                it
                    .onLoading {
                        Log.d("aaaaaaa ", "a")
                    }
                    .onSuccess {
                        Log.d("aaaaaaa ", "$it")
                    }
                    .onError { errCode, errMessage ->
                        Log.d("aaaaaaa ", "c")
                    }
            }
    }

}

