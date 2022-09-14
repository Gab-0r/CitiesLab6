package com.example.citieslab6.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.citieslab6.server.citiesRepository.CitiesRepository
import com.example.citieslab6.server.model.citiesList
import com.example.citieslab6.server.model.citiesListItem
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val citiesRepository = CitiesRepository()

    private val _citiesLoaded : MutableLiveData<ArrayList<citiesListItem>> = MutableLiveData()
    val citiesLoaded: LiveData<ArrayList<citiesListItem>> = _citiesLoaded

    fun getCities() {
        viewModelScope.launch {
            val CitiesList: citiesList = citiesRepository.getCities()
            _citiesLoaded.postValue(CitiesList as ArrayList<citiesListItem>)
        }
    }
}