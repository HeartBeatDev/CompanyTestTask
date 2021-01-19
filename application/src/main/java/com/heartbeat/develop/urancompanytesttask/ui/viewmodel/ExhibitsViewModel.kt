package com.heartbeat.develop.urancompanytesttask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heartbeat.develop.model.Exhibit
import com.heartbeat.develop.model.loader.ExhibitsLoader
import kotlinx.coroutines.launch
import javax.inject.Inject

class ExhibitsViewModel @Inject constructor(val loader: ExhibitsLoader) : ViewModel() {

    private val exhibitsMutableLiveData: MutableLiveData<List<Exhibit>> = MutableLiveData()
    val exhibitsLiveData: LiveData<List<Exhibit>>
        get() = exhibitsMutableLiveData

    init {
        loadExhibits()
    }

    private fun loadExhibits() = viewModelScope.launch {
        val exhibitsList = loader.getExhibitList()
        exhibitsMutableLiveData.value = exhibitsList
    }
}