package com.heartbeat.develop.model.loader

import com.heartbeat.develop.model.Exhibit

interface ExhibitsLoader {

    suspend fun getExhibitList(): List<Exhibit>
}