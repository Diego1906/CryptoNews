package br.com.cryptonews.remote

import br.com.cryptonews.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitConfig : IService {

    private val retrofit: Retrofit

    init {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BuildConfig.URL_BASE)
            .build()
    }

    override fun getService(): IRetrofitAPI {
        return retrofit.create(IRetrofitAPI::class.java)
    }
}
