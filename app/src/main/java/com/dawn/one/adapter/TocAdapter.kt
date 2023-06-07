package com.dawn.one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dawn.one.R
import com.dawn.one.data.FeatureDemo
import com.dawn.one.databinding.CatTocItemBinding

class TocAdapter(private val featureDemos: List<FeatureDemo>) : Adapter<TocViewHolder>() {

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
        holder.bind(featureDemos[position])
    }
}

class TocViewHolder(view: View) : ViewHolder(view) {

    private val binding = CatTocItemBinding.bind(view)

    val catTocTitle = binding.catTocTitle
    val catTocImage = view.findViewById<ImageView>(R.id.cat_toc_image)


    fun bind(featureDemo: FeatureDemo) {
        val title = featureDemo.title
        ViewCompat.setTransitionName(itemView, title)
        catTocTitle.text = title
        catTocImage.setImageResource(featureDemo.drawableResId)
        binding.root.setOnClickListener {

        }
    }

}