package com.example.walmartcodingofnitya.domain.repository

import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin

interface ICountryRepository {
    suspend fun getCountryDetails(): List<CountryListDoamin>
}