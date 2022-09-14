package com.example.citieslab6.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citieslab6.local.LocalCity
import com.example.citieslab6.local.repository.LocalCityRepository
import com.example.citieslab6.server.model.citiesListItem
import kotlinx.coroutines.launch
import java.sql.Types.NULL

class DetailViewModel : ViewModel() {

    val localCityRepository = LocalCityRepository()

    private val _cityExist: MutableLiveData<Boolean> = MutableLiveData()
    val  cityExist: LiveData<Boolean> = _cityExist

    fun addCityToFavorites(city: citiesListItem) {
        val localcity = city.key?.let {
            LocalCity(
                it, city.englishName, city.country?.englishName,
                city.region?.englishName, city.timeZone?.name, city.timeZone?.gmtOffset?.toInt().toString(),
                city.geoPosition?.latitude.toString(), city.geoPosition?.longitude.toString())
        }
        viewModelScope.launch {
            localcity?.let { localCityRepository.saveCity(it) }
        }
    }

    fun searchCity(city_key: String?) {
        var cityexist = false
        viewModelScope.launch {
            val localCity = localCityRepository.searchCity(city_key)
            if(localCity != null){
                cityexist = true
            }
            _cityExist.postValue(cityexist)
        }
    }
}