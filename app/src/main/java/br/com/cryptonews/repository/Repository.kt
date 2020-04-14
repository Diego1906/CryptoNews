package br.com.cryptonews.repository

import br.com.cryptonews.domain.NewsModel
import br.com.cryptonews.mapper.mapToModel
import br.com.cryptonews.remote.IService

class Repository(val service: IService) : IRepository {

    override suspend fun getListNews(params: Triple<String, String, String>): NewsModel {
        return service.getService()
            .getListNews(params.first, params.second, params.third)
            .mapToModel()
    }
}