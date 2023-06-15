package com.dawn.one.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.dawn.one.databinding.ActivityM3Binding
import com.dawn.one.ui.base.BaseActivity

/**
 * Material 3
 */
@Route(path = "/app/activity/M3Activity")
class M3Activity : BaseActivity() {

    private lateinit var binding: ActivityM3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityM3Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}