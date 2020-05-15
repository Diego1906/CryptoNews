package br.com.cryptonews.application

import android.app.Application
import android.content.Context
import br.com.cryptonews.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }

        setContext(applicationContext)
    }

    companion object {
        private lateinit var INSTANCE: Context

        private fun setContext(context: Context) {
            synchronized(App::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = context
                }
            }
        }

        fun getContext() = INSTANCE
    }
}