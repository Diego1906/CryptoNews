package br.com.cryptonews.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModel(
    val status: String?,
    val totalResults: Int,
    val articles: List<ArticleModel>? = null
) : Parcelable

@Parcelize
data class ArticleModel(
    val source: SourceModel?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    var publishedAt: String?,
    val content: String?
) : Parcelable

@Parcelize
data class SourceModel(
    val id: String?,
    val name: String?
) : Parcelable