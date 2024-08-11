package com.example.walmartcodingofnitya.data.repository

import com.example.walmartcodingofnitya.data.mapper.CountryMapper
import com.example.walmartcodingofnitya.data.remote.CountryApiService
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin
import com.example.walmartcodingofnitya.domain.repository.ICountryRepository

class CountryRepository(
    private val apiService: CountryApiService = CountryApiService.getInstance()
): ICountryRepository {
    override suspend fun getCountryDetails(): List<CountryListDoamin> {
        val response = apiService.getCountryList()
        if (response.isSuccessful){
            val countryList = response.body() ?: emptyList()
            return countryList.map{ CountryMapper.mapToDomain(it) }
        }
        else{
            throw Exception("Failed to fetch country details")
        }
    }
}