package com.example.citieslab6.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_city")
data class LocalCity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "cityName") val cityName: String?,
    @ColumnInfo(name = "cityCountry") val cityCountry: String?,
    @ColumnInfo(name = "cityRegion") val cityRegion: String?,
    @ColumnInfo(name = "cityTimeZone") val cityTimeZone: String?,
    @ColumnInfo(name = "cityGmt") val cityGmt: String?,
    @ColumnInfo(name = "cityLatitude") val cityLatitude: String?,
    @ColumnInfo(name = "cityLongitude") val cityLongitude: String?
)