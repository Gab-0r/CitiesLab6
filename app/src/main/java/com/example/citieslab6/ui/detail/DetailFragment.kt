package com.example.citieslab6.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.citieslab6.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = args.city
        with(detailBinding){
            detailCityName.text = city.englishName
            detailCityCountryValue.text = city.country?.englishName
            detailCityCountryRegionValue.text = city.region?.englishName
            detailCityTimezoneValue.text = city.timeZone?.name
            gmtOffset.text = city.timeZone?.gmtOffset?.toInt().toString()
            detailCityLatitudValue.text = city.geoPosition?.latitude.toString()
            detailCityLongitudValue.text = city.geoPosition?.longitude.toString()

            favoriteImageView.setOnClickListener {
                detailViewModel.addCityToFavorites(city)
            }

        }
    }
}