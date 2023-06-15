package com.dawn.lib.wan

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Route(path = "/wan/activity/WanActivity")
class WanActivity : AppCompatActivity() {

    private val viewModel by viewModels<WanViewModel> { WanViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wan_activity_wan)
        lifecycleScope.launch {
            viewModel.onWanArticleUiState.collect {
                Log.d("aaaaaaaaaaa","$it")
            }

        }
    }

}