package br.com.cryptonews.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleObject(
    @Json(name = "source")
    val source: SourceObject?,

    @Json(name = "author")
    val author: String?,

    @Json(name = "title")
    val title: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "url")
    val url: String?,

    @Json(name = "urlToImage")
    val urlToImage: String?,

    @Json(name = "publishedAt")
    var publishedAt: String?,

    @Json(name = "content")
    val content: String?
) : Parcelable