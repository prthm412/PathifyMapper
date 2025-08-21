package com.pathify.mapper.model

data class FloorRef(
    val id: String,
    val displayName: String
)

data class Building(
    val id: String,
    val name: String,
    val geoLat: Double? = null,
    val geoLon: Double? = null,
    val floors: MutableList<FloorRef> = mutableListOf()
)

data class AppState(
    val buildings: MutableList<Building> = mutableListOf()
)