package com.example.citieslab6.local.repository

import com.example.citieslab6.CitiesData2022
import com.example.citieslab6.local.CityDao
import com.example.citieslab6.local.LocalCity

class LocalCityRepository {
    suspend fun saveCity(localcity: LocalCity) {
        val cityDao: CityDao = CitiesData2022.database.CityDao()
        cityDao.createCity(localcity)
    }

    suspend fun getCities() = CitiesData2022.database.CityDao().getCities()
    suspend fun deleteCity(localCity: LocalCity) {
        val cityDao: CityDao = CitiesData2022.database.CityDao()
        cityDao.deleteCity(localCity)
    }
}