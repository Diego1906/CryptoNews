package br.com.cryptonews.repository

import br.com.cryptonews.entities.News
import br.com.cryptonews.remote.IService

class Repository(val service: IService) : IRepository {

    override suspend fun getRemoteListCryptoNews(
        qInTitle: String,
        dateFrom: String,
        dateTo: String
    ): News {
        return service.getService().getRemoteListCryptoNews(qInTitle, dateFrom, dateTo)
    }
}