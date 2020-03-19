package br.com.cryptonews.mapper

import br.com.cryptonews.entities.News
import br.com.cryptonews.model.NewsObject

fun News.mapToObject() = NewsObject(
    status = this.status,
    totalResults = this.totalResults,
    articles = this.articles?.map {
        it.mapToObject()
    }
)
