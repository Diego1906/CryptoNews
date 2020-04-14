package br.com.cryptonews.application

import android.app.Application
import android.content.Context
import br.com.cryptonews.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CryptoNewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CryptoNewsApplication)
            modules(appModule)
        }
    }

    companion object {

        private lateinit var INSTANCE: Context

        fun setContext(context: Context) {
            synchronized(CryptoNewsApplication::class.java) {
                if (!Companion::INSTANCE.isInitialized) {
                    INSTANCE = context
                }
            }
        }

        fun getContext() =
            INSTANCE
    }
}