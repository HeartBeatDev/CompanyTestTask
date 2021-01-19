package com.heartbeat.develop.urancompanytesttask.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.heartbeat.develop.urancompanytesttask.di.module.viewmodel.ViewModelFactory
import com.heartbeat.develop.urancompanytesttask.di.module.viewmodel.ViewModelKey
import com.heartbeat.develop.urancompanytesttask.ui.viewmodel.ExhibitsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ExhibitsViewModel::class)
    abstract fun bindExhibitsViewModel(viewModel: ExhibitsViewModel): ViewModel
}