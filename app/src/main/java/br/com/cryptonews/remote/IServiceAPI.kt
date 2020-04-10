package br.com.cryptonews.remote

import br.com.cryptonews.BuildConfig
import br.com.cryptonews.remote.dto.News
import retrofit2.http.GET
import retrofit2.http.Query

interface IServiceAPI {

    @GET("everything")
    suspend fun getRemoteListCryptoNews(
        @Query("qInTitle") qInTitle: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String = "publishedAt",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): News
}