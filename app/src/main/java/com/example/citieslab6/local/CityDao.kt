package com.example.citieslab6.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CityDao {

    @Insert
    suspend fun createCity(city: LocalCity)

}