package com.dawn.one.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dawn.one.R
import com.dawn.one.databinding.ActivityM3Binding
import com.dawn.one.ui.base.BaseActivity
import com.google.android.material.transition.platform.MaterialContainerTransform

/**
 * Material 3
 */
class M3Activity : BaseActivity() {

    private lateinit var binding: ActivityM3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityM3Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}