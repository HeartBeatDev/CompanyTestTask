package com.heartbeat.develop.urancompanytesttask.di.module

import android.content.Context
import com.heartbeat.develop.urancompanytesttask.App
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(application: App) {

    private val applicationContext: Context = application

    @Provides
    fun provideApplicationContext(): Context = applicationContext
}