package com.example.citieslab6

import android.app.Application
import androidx.room.Room
import com.example.citieslab6.local.CityDao
import com.example.citieslab6.local.CityDatabase

class CitiesData2022 : Application() {

    companion object{
        lateinit var database: CityDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            CityDatabase::class.java,
            "city_db",
        ).build()

    }

}