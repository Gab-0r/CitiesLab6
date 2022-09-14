package com.example.citieslab6.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.citieslab6.R
import com.example.citieslab6.databinding.CardItemCityBinding
import com.example.citieslab6.server.model.citiesListItem

class CitiesAdapter(
    private val CitiesList: ArrayList<citiesListItem>,
    private val onItemClicked: (citiesListItem) -> Unit
) : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item_city, parent, false)
        return CitiesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val city = CitiesList[position]
        holder.bindCities(city)
        holder.itemView.setOnClickListener { onItemClicked(CitiesList[position]) }
    }

    override fun getItemCount(): Int = CitiesList.size

    fun appendItems(newList: ArrayList<citiesListItem>){
        CitiesList.clear()
        CitiesList.addAll(newList)
        notifyDataSetChanged()
    }

    class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding = CardItemCityBinding.bind(itemView)

        fun bindCities(city: citiesListItem){
            with(binding){
                city.let {
                    cityNameTextView.text = city.englishName
                    cityCountryValueTextView.text = city.country?.englishName
                }
            }
        }
    }
}