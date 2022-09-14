package com.example.citieslab6.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CityDao {

    @Insert
    suspend fun createCity(city: LocalCity)

    @Query("SELECT * FROM table_city")
    suspend fun getCities() : MutableList<LocalCity>
}