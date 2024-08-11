package com.example.walmartcodingofnitya.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.walmartcodingofnitya.databinding.CountryListItemBinding
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin

class CountryListAdapter(
    private val countryList: List<CountryListDoamin>
):RecyclerView.Adapter<CountryItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryItemViewHolder {
        val binding = CountryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryItemViewHolder(binding)
    }

    override fun getItemCount() = countryList.size

    override fun onBindViewHolder(holder: CountryItemViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

}