package com.example.weatherproject.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //Timber 세팅
        Timber.plant(Timber.DebugTree())
    }
}