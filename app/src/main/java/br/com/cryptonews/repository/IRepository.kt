package br.com.cryptonews.repository

import br.com.cryptonews.domain.NewsModel

interface IRepository {

    //TODO poderia ter usado um Triple() o objeto alocado na memoria seria apenas um
    suspend fun getListNews(title: String, dateFrom: String, dateTo: String): NewsModel
}