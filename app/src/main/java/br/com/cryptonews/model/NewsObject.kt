package br.com.cryptonews.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsObject(
    @Json(name = "status")
    val status: String?,

    @Json(name = "totalResults")
    val totalResults: Int,

    @Json(name = "articles")
    val articles: List<ArticleObject>? = null
) : Parcelable