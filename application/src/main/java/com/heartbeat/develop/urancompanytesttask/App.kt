package com.heartbeat.develop.urancompanytesttask

import android.app.Application
import com.heartbeat.develop.urancompanytesttask.di.ApplicationComponent
import com.heartbeat.develop.urancompanytesttask.di.DaggerApplicationComponent
import com.heartbeat.develop.urancompanytesttask.di.module.ApplicationModule

class App : Application() {

    lateinit var diComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        diComponent =
            DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}