package com.dawn.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dawn.one.databinding.ActivityMainBinding
import com.dawn.one.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView(savedInstanceState)
        subscribeUi()
        onEvent()
    }

    private fun initView(savedInstanceState: Bundle?){

    }

    private fun subscribeUi(){

    }

    private fun onEvent(){

    }

}