package com.example.citieslab6.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citieslab6.local.LocalCity
import com.example.citieslab6.local.repository.LocalCityRepository
import com.example.citieslab6.server.model.citiesListItem
import kotlinx.coroutines.launch
import java.sql.Types.NULL

class DetailViewModel : ViewModel() {

    val localCityRepository = LocalCityRepository()

    fun addCityToFavorites(city: citiesListItem) {
        val localcity = LocalCity(NULL, city.englishName, city.country?.englishName,
            city.region?.englishName, city.timeZone?.name, city.timeZone?.gmtOffset?.toInt().toString(),
            city.geoPosition?.latitude.toString(), city.geoPosition?.longitude.toString())
        viewModelScope.launch {
            localCityRepository.saveCity(localcity)
        }
    }
}