package br.com.cryptonews.remote

import br.com.cryptonews.remote.IRetrofitAPI

interface IService {
    fun getService(): IRetrofitAPI
}