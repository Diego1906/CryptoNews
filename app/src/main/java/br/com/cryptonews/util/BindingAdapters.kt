package br.com.cryptonews.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.cryptonews.R
import br.com.cryptonews.domain.ArticleModel
import br.com.cryptonews.ui.adapter.ListNewsAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("downloadImage")
fun downloadImage(imageView: ImageView, urlToImage: String?) {
    urlToImage?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imageView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, articles: List<ArticleModel>?) {
    val adapter = recyclerView.adapter as ListNewsAdapter
    adapter.submitList(articles)
}