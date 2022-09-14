package com.example.citieslab6.server.model

import com.google.gson.annotations.SerializedName

data class GeoPosition(
    @SerializedName("Elevation")
    val elevation: Elevation? = null,
    @SerializedName("Latitude")
    val latitude: Double? = null,
    @SerializedName("Longitude")
    val longitude: Double? = null
)