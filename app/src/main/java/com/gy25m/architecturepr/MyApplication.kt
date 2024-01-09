package com.gy25m.architecturepr

import android.app.Application
import androidx.room.Room
import com.gy25m.architecturepr.db.AppDatabase
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Koin
//        startKoin {
//            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
//            androidContext(this@MyApplication)
//            modules(networkModule, repositoryModule, useCaseModule, viewModelModule)
//        }
    }
}