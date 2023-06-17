package com.dawn.lib.wan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.dawn.lib.model.Article
import com.dawn.lib.ui.OnItemClickListener
import com.dawn.lib.wan.databinding.WanArticleItemListBinding

class ArticleAdapter : Adapter<ArticleViewHolder>() {

    private val articleList: List<Article> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            WanArticleItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

    }
}

class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = WanArticleItemListBinding.bind(view)

    fun bind(listener: OnItemClickListener<Article>? = null, featureDemo: Article, position: Int) {
        binding.root.setOnClickListener {
            listener?.invoke(it, position, featureDemo)
        }
    }


}