package br.com.cryptonews.remote

import br.com.cryptonews.entities.News
import retrofit2.http.GET
import retrofit2.http.Path

interface IRetrofitAPI {
    @GET("?qInTitle={qInTitle}&language=en&from={from}&to={to}&apiKey={apiKey}")
    suspend fun getRemoteListCryptoNews(
        @Path("qInTitle") qInTitle: String,
        @Path("from") from: String,
        @Path("to") to: String,
        @Path("apiKey") apiKey: String
    ): News
}