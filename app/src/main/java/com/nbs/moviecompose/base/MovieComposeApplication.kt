package com.nbs.moviecompose.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.nbs.moviecompose.di.applicationModule
import com.nbs.moviecompose.di.featureModule
import com.nbs.moviecompose.utils.ContextProvider
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieComposeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MovieComposeApplication)
            modules(
                listOf(
                    applicationModule,
                    featureModule
                )
            )
            ContextProvider.instance.initialize(applicationContext)
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}