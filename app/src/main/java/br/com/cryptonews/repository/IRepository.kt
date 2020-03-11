package br.com.cryptonews.repository

import br.com.cryptonews.entities.News

interface IRepository {

    suspend fun getRemoteListCryptoNews(
        qInTitle: String,
        dateFrom: String,
        dateTo: String
    ): News
}