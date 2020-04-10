package br.com.cryptonews.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.cryptonews.databinding.ItemListNewsBinding
import br.com.cryptonews.domain.ArticleModel

class ListNewsAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ArticleModel, ListNewsAdapter.ItemHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val article = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(article)
        }
        holder.bind(article)
    }

    class ItemHolder private constructor(private var view: ItemListNewsBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bind(article: ArticleModel) {
            view.article = article
            view.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ItemHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = ItemListNewsBinding.inflate(inflater)
                return ItemHolder(view)
            }
        }
    }

    object DiffCallBack : DiffUtil.ItemCallback<ArticleModel>() {
        override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
            return (oldItem.source?.id == newItem.source?.id && oldItem.title == newItem.title)
        }
    }

    class OnClickListener(private val clickListener: (article: ArticleModel) -> Unit) {
        fun onClick(article: ArticleModel) = clickListener(article)
    }
}