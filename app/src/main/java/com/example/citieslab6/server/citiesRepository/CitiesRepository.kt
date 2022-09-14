package com.example.citieslab6.server.citiesRepository

import com.example.citieslab6.server.CitiesDB

class CitiesRepository {

    private val apiKey = "Q5cQZpvHYoriNG6IAjtI6FYIGXgGMV4p"

    suspend fun getCities() = CitiesDB.retrofit.getCities(apiKey)

}