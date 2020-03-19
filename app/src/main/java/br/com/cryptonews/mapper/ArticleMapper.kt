package br.com.cryptonews.mapper

import br.com.cryptonews.entities.Article
import br.com.cryptonews.model.ArticleObject
import br.com.cryptonews.util.onDateFormat

fun Article.mapToObject() = ArticleObject(
    source = this.source?.mapToObject(),
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt?.onDateFormat(),
    content = this.content
)