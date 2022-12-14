package com.example.citieslab6.server.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class citiesListItem(
    @SerializedName("AdministrativeArea")
    val administrativeArea: AdministrativeArea? = null,
    @SerializedName("Country")
    val country: Country? = null,
    @SerializedName("DataSets")
    val dataSets: List<String?>? = null,
    @SerializedName("EnglishName")
    val englishName: String? = null,
    @SerializedName("GeoPosition")
    val geoPosition: GeoPosition? = null,
    @SerializedName("IsAlias")
    val isAlias: Boolean? = null,
    @SerializedName("Key")
    val key: String? = null,
    @SerializedName("LocalizedName")
    val localizedName: String? = null,
    @SerializedName("PrimaryPostalCode")
    val primaryPostalCode: String? = null,
    @SerializedName("Rank")
    val rank: Int? = null,
    @SerializedName("Region")
    val region: Region? = null,
    @SerializedName("SupplementalAdminAreas")
    val supplementalAdminAreas: List<SupplementalAdminArea?>? = null,
    @SerializedName("TimeZone")
    val timeZone: TimeZone? = null,
    @SerializedName("Type")
    val type: String? = null,
    @SerializedName("Version")
    val version: Int? = null
) : Serializable