package com.example.walmartcodingofnitya.data.repository

import com.example.walmartcodingofnitya.data.mapper.CountryMapper
import com.example.walmartcodingofnitya.data.remote.CountryApiService
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin
import com.example.walmartcodingofnitya.domain.repository.ICountryRepository

class CountryRepository(): ICountryRepository {
    private val apiService: CountryApiService =  CountryApiService.getInstance()
    override suspend fun getCountryDetails(): List<CountryListDoamin> {
        val response = apiService.getCountryList()
        if (response.isSuccessful){
            return response.body()?.map{ CountryMapper.mapToDomain(it) } ?: emptyList()
        }
        else{
            throw Exception("Failed to fetch country details")
        }
    }
}