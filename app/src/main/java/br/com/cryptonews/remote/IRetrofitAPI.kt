package br.com.cryptonews.remote

import br.com.cryptonews.BuildConfig
import br.com.cryptonews.entities.News
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofitAPI {

    @GET("everything")
    suspend fun getRemoteListCryptoNews(
        @Query("qInTitle") qInTitle: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): News
}