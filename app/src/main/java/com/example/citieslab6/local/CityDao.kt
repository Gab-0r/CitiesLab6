package com.example.citieslab6.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CityDao {

    @Insert
    suspend fun createCity(city: LocalCity)

    @Query("SELECT * FROM table_city")
    suspend fun getCities() : MutableList<LocalCity>
    @Delete
    suspend fun deleteCity(localCity: LocalCity)
    @Query("SELECT * FROM table_city WHERE id LIKE :cityKey")
    suspend fun searchCity(cityKey: String?): LocalCity
}