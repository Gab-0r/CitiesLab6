package com.example.citieslab6.server

import com.example.citieslab6.server.model.citiesList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("locations/v1/topcities/50?")

    suspend fun getCities(@Query("apikey") apiKey: String) : citiesList

}