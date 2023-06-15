package com.dawn.one

import android.content.Intent
import android.os.Bundle
import androidx.core.math.MathUtils
import androidx.recyclerview.widget.GridLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dawn.one.adapter.TocAdapter
import com.dawn.one.data.FeatureDemo
import com.dawn.one.databinding.ActivityMainBinding
import com.dawn.one.ui.M3Activity
import com.dawn.one.ui.base.BaseActivity
import com.dawn.one.utilities.Jump

@Route(path = "/app/activity/MainActivity")
class MainActivity : BaseActivity() {

    companion object {
        private const val GRID_SPAN_COUNT_MIN = 1
        private const val GRID_SPAN_COUNT_MAX = 4
    }


    private lateinit var binding: ActivityMainBinding

    private lateinit var tocAdapter: TocAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView(savedInstanceState)
        subscribeUi()
        onEvent()
    }

    private fun initView(savedInstanceState: Bundle?) {
        val gridSpanCount = calculateGridSpanCount()

        tocAdapter = TocAdapter(buildFeatureList())
        tocAdapter.setOnItemClickListener { view, position, featureDemo ->
            when (position) {
                0 -> {
                    Jump.startActivityInternal(this, M3Activity::class.java, view)
                }

                1 -> {
                    ARouter.getInstance().build("/wan/activity/WanActivity").navigation()
                }
            }
        }
        binding.mainRecyclerView.apply {
            layoutManager = GridLayoutManager(context, gridSpanCount)

            adapter = tocAdapter
        }


    }

    private fun subscribeUi() {

    }

    private fun onEvent() {

    }

    private fun calculateGridSpanCount(): Int {
        val displayMetrics = resources.displayMetrics
        val displayWidth = displayMetrics.widthPixels
        val itemSize = resources.getDimensionPixelSize(R.dimen.cat_toc_item_size)
        val gridSpanCount = displayWidth / itemSize
        return MathUtils.clamp(gridSpanCount, GRID_SPAN_COUNT_MIN, GRID_SPAN_COUNT_MAX)
    }

    private fun buildFeatureList(): List<FeatureDemo> {

        val list = arrayListOf<FeatureDemo>()

        list.add(FeatureDemo("Material 3", R.drawable.material_3))
        list.add(FeatureDemo("网络请求", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("RecyclerView", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("Load Image", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("Video Player", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("multi adapter", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("LeakCanary", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("Compose", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("AutoXJs", R.drawable.ic_text_field_24px))
        list.add(FeatureDemo("ChatGpt", R.drawable.ic_text_field_24px))

        return list
    }

}