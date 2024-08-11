package com.example.walmartcodingofnitya.domain.usecase

import com.example.walmartcodingofnitya.data.repository.CountryRepository

class CountryUseCase(private val countryRepository: CountryRepository) {
    suspend operator fun invoke() = countryRepository.getCountryDetails()
}