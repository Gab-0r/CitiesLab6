package com.example.citieslab6.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citieslab6.local.LocalCity
import com.example.citieslab6.local.repository.LocalCityRepository
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    var localCityRepository = LocalCityRepository()

    private val _citiesLoaded : MutableLiveData<ArrayList<LocalCity>> = MutableLiveData()
    val citiesLoaded : LiveData<ArrayList<LocalCity>> = _citiesLoaded

    fun loadCities() {
        viewModelScope.launch {
            val listFavoriteCities = localCityRepository.getCities()
            _citiesLoaded.postValue(listFavoriteCities as ArrayList<LocalCity>)
        }
    }

    fun deleteCity(localCity: LocalCity) {
        viewModelScope.launch {
            localCityRepository.deleteCity(localCity)
        }
    }
}