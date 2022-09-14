package com.example.citieslab6.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.citieslab6.R
import com.example.citieslab6.databinding.CardItemCityBinding
import com.example.citieslab6.local.LocalCity
import com.example.citieslab6.server.model.citiesListItem

class CitiesFavoriteAdapter(
    private val CitiesList: ArrayList<LocalCity>,
    private val onItemClicked: (LocalCity) -> Unit
) : RecyclerView.Adapter<CitiesFavoriteAdapter.CitiesFavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesFavoriteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item_city, parent, false)
        return CitiesFavoriteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CitiesFavoriteViewHolder, position: Int) {
        val city = CitiesList[position]
        holder.bindCities(city)
        holder.itemView.setOnClickListener { onItemClicked(CitiesList[position]) }
    }

    override fun getItemCount(): Int = CitiesList.size

    fun appendItems(newList: ArrayList<LocalCity>){
        CitiesList.clear()
        CitiesList.addAll(newList)
        notifyDataSetChanged()
    }

    class CitiesFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = CardItemCityBinding.bind(itemView)

        fun bindCities(city: LocalCity){
            with(binding){
                city.let {
                    cityNameTextView.text = city.cityName
                    cityCountryValueTextView.text = city.cityCountry
                }
            }
        }
    }
}