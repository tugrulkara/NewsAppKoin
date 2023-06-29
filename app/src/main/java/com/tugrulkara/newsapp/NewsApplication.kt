package com.tugrulkara.newsapp

import android.app.Application
import com.tugrulkara.newsapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsApplication)
            modules(appModule)
        }
    }
}