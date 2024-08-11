package com.example.walmartcodingofnitya.presentation.view.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.walmartcodingofnitya.databinding.CountryListItemBinding
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin

class CountryItemViewHolder(
    private val binding: CountryListItemBinding
) : ViewHolder(binding.root) {
    fun bind(countryItem: CountryListDoamin) {
        with(binding) {
            countryName.text = "${countryItem.name}, "
            countryRegion.text = countryItem.region
            countryCode.text = countryItem.code
            countryCapital.text = countryItem.capital
        }

    }
}