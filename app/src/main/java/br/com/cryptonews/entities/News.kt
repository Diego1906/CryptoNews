package br.com.cryptonews.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    @Json(name = "status")
    val status: String,

    @Json(name = "totalResults")
    val totalResults: Int,

    @Json(name = "articles")
    val articles: List<Article>? = null
) : Parcelable