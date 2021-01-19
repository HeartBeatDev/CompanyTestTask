package com.heartbeat.develop.urancompanytesttask.di

import com.heartbeat.develop.urancompanytesttask.di.module.ApplicationModule
import com.heartbeat.develop.urancompanytesttask.di.module.DataModule
import com.heartbeat.develop.urancompanytesttask.di.module.ViewModelsModule
import com.heartbeat.develop.urancompanytesttask.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, ApplicationModule::class, ViewModelsModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}