package com.example.citieslab6.server.model

import com.google.gson.annotations.SerializedName

data class Elevation(
    @SerializedName("Imperial")
    val imperial: Imperial? = null,
    @SerializedName("Metric")
    val metric: Metric? = null
)