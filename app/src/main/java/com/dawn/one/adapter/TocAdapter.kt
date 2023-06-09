package com.dawn.one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dawn.one.R
import com.dawn.one.data.FeatureDemo
import com.dawn.one.databinding.CatTocItemBinding

typealias OnItemClickListener = (view: View, position: Int, featureDemo: FeatureDemo) -> Unit

class TocAdapter(private val featureDemos: List<FeatureDemo>) : Adapter<TocViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TocViewHolder {
        return TocViewHolder(
            CatTocItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )
    }

    override fun getItemCount(): Int {
        return featureDemos.size
    }

    override fun onBindViewHolder(holder: TocViewHolder, position: Int) {
        holder.bind(onItemClickListener, featureDemos[position], position)
    }


    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

}

class TocViewHolder(view: View) : ViewHolder(view) {

    private val binding = CatTocItemBinding.bind(view)

    val catTocTitle = binding.catTocTitle
    val catTocImage = view.findViewById<ImageView>(R.id.cat_toc_image)


    fun bind(listener: OnItemClickListener? = null, featureDemo: FeatureDemo, position: Int) {
        val title = featureDemo.title
        ViewCompat.setTransitionName(binding.root, title)
        catTocTitle.text = title
        catTocImage.setImageResource(featureDemo.drawableResId)
        binding.root.setOnClickListener {
            listener?.invoke(it, position, featureDemo)
        }
    }

}