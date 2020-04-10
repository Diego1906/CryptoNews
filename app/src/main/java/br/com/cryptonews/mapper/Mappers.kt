package br.com.cryptonews.mapper

import br.com.cryptonews.domain.ArticleModel
import br.com.cryptonews.domain.NewsModel
import br.com.cryptonews.domain.SourceModel
import br.com.cryptonews.entities.Article
import br.com.cryptonews.entities.News
import br.com.cryptonews.entities.Source
import br.com.cryptonews.util.onDateFormat

fun News.mapToModel() = NewsModel(
    status = this.status,
    totalResults = this.totalResults,
    articles = this.articles?.map {
        it.mapToModel()
    }
)

fun Article.mapToModel() = ArticleModel(
    source = this.source?.mapToModel(),
    author = this.author,
    title = this.title,
    description = this.description,
    url = this.url,
    urlToImage = this.urlToImage,
    publishedAt = this.publishedAt?.onDateFormat(),
    content = this.content
)

fun Source.mapToModel() = SourceModel(
    id = this.id,
    name = this.name
)