package br.com.cryptonews.repository

import br.com.cryptonews.domain.NewsModel

interface IRepository {

    suspend fun getRemoteListCryptoNews(title: String, dateFrom: String, dateTo: String): NewsModel
}