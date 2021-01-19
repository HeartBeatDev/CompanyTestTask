package com.heartbeat.develop.model

data class ExhibitResponse(val list: List<Exhibit>)

data class Exhibit(val title: String, val images: List<String>)
