package br.com.cryptonews.repository

import br.com.cryptonews.mapper.mapToModel
import br.com.cryptonews.domain.NewsModel
import br.com.cryptonews.remote.IService

class Repository(val service: IService) : IRepository {

    override suspend fun getRemoteListCryptoNews(
        qInTitle: String,
        dateFrom: String,
        dateTo: String
    ): NewsModel {
        return service.getService()
            .getRemoteListCryptoNews(qInTitle, dateFrom, dateTo)
            .mapToModel()
    }
}