package br.com.cryptonews.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppGlobal : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppGlobal)
            modules(appModule)
        }
    }
}