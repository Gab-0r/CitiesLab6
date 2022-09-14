package com.example.citieslab6.ui.favorites

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.citieslab6.R
import com.example.citieslab6.databinding.FragmentFavoritesBinding
import com.example.citieslab6.local.LocalCity

class FavoritesFragment : Fragment() {

    private lateinit var favoritesBinding: FragmentFavoritesBinding
    private lateinit var favoritesViewModel: FavoritesViewModel
    private lateinit var citiesFavoriteAdapter: CitiesFavoriteAdapter
    private var citiesList: ArrayList<LocalCity> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        favoritesViewModel = ViewModelProvider(this)[FavoritesViewModel::class.java]
        favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)

        citiesFavoriteAdapter = CitiesFavoriteAdapter(citiesList,
            onItemClicked = {onItemClicked(it)},
            onLongItemClicked = {onItemLongClicked(it)}
            )

        favoritesBinding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@FavoritesFragment.context)
            adapter = citiesFavoriteAdapter
            setHasFixedSize(false)
        }


        favoritesViewModel.citiesLoaded.observe(viewLifecycleOwner){
            citiesFavoriteAdapter.appendItems(it)
        }

        favoritesViewModel.loadCities()

        val root: View = favoritesBinding.root
        return root
    }

    private fun onItemLongClicked(localCity: LocalCity) {
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setMessage("Desea eliminar ${localCity.cityName} de sus favoritos?")
                setPositiveButton(R.string.accept){ dialog, id ->
                    favoritesViewModel.deleteCity(localCity)
                    favoritesViewModel.loadCities()
                }
                setNegativeButton(R.string.cancel){ dialog, id ->
                }
            }
            builder.create()
        }
        alertDialog?.show()
    }


    private fun onItemClicked(localcity: LocalCity) {

    }
}