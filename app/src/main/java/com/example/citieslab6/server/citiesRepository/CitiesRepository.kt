package com.example.citieslab6.server.citiesRepository

import com.example.citieslab6.server.CitiesDB

class CitiesRepository {

    private val apiKey = "l0Bl9XwAyRITFZZc86nzWUdneDURaas7"

    suspend fun getCities() = CitiesDB.retrofit.getCities(apiKey)

}