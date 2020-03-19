package br.com.cryptonews.repository

import br.com.cryptonews.model.NewsObject

interface IRepository {

    suspend fun getRemoteListCryptoNews(
        qInTitle: String,
        dateFrom: String,
        dateTo: String
    ): NewsObject
}