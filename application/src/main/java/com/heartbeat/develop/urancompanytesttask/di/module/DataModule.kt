package com.heartbeat.develop.urancompanytesttask.di.module

import android.content.Context
import com.heartbeat.develop.file_exhibits_loader.FileExhibitsLoaderImpl
import com.heartbeat.develop.model.loader.ExhibitsLoader
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideFileExhibitsLoader(loader: FileExhibitsLoaderImpl): ExhibitsLoader
}