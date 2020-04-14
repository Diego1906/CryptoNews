package br.com.cryptonews.repository

import br.com.cryptonews.domain.NewsModel

interface IRepository {

    suspend fun getListNews(params: Triple<String, String, String>): NewsModel
}