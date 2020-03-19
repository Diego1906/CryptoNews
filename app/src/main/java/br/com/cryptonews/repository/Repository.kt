package br.com.cryptonews.repository

import br.com.cryptonews.mapper.mapToObject
import br.com.cryptonews.model.NewsObject
import br.com.cryptonews.remote.IService

class Repository(val service: IService) : IRepository {

    override suspend fun getRemoteListCryptoNews(
        qInTitle: String,
        dateFrom: String,
        dateTo: String
    ): NewsObject {
        return service.getService()
            .getRemoteListCryptoNews(qInTitle, dateFrom, dateTo)
            .mapToObject()
    }
}