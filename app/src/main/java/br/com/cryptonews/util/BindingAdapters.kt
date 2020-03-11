package br.com.cryptonews.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import br.com.cryptonews.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("downloadImage")
fun ImageView.downloadImage(urlToImage: String?) {
    urlToImage?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(this.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    //.override(200, 300)
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }
}