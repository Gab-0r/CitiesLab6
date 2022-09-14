package com.example.citieslab6.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalCity::class], version = 1)
abstract class CityDatabase : RoomDatabase() {
    abstract fun CityDao() : CityDao
}