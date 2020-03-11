package br.com.cryptonews.di

import br.com.cryptonews.remote.IService
import br.com.cryptonews.remote.RetrofitConfig
import br.com.cryptonews.repository.IRepository
import br.com.cryptonews.repository.Repository
import br.com.cryptonews.viewmodel.NewsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { NewsViewModel(repository = get(), application = androidApplication()) }
    single<IRepository> { Repository(service = get()) }
    single<IService> { RetrofitConfig() }
}