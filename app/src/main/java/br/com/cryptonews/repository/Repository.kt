package br.com.cryptonews.repository

import br.com.cryptonews.domain.NewsModel
import br.com.cryptonews.mapper.mapToModel
import br.com.cryptonews.remote.IService

class Repository(val service: IService) : IRepository {

    override suspend fun getRemoteListCryptoNews(
        title: String, dateFrom: String, dateTo: String
    ): NewsModel {
        return service.getService()
            .getRemoteListCryptoNews(title, dateFrom, dateTo)
            .mapToModel()
    }
}