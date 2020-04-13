package br.com.cryptonews.mapper

import br.com.cryptonews.domain.ArticleModel
import br.com.cryptonews.domain.NewsModel
import br.com.cryptonews.domain.SourceModel
import br.com.cryptonews.remote.dto.Article
import br.com.cryptonews.remote.dto.News
import br.com.cryptonews.remote.dto.Source
import br.com.cryptonews.util.onDateFormat

//TODO Alterar para um nome mais claro, ex: MappersResponse
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