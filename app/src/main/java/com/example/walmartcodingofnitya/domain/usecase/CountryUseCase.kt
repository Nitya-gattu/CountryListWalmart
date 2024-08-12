package com.example.walmartcodingofnitya.domain.usecase

import com.example.walmartcodingofnitya.data.repository.CountryRepository

/**
 * Use case class that provides a single point of interaction for fetching country details.
 *
 * @property countryRepository The repository used to retrieve country data.
 */
class CountryUseCase(private val countryRepository: CountryRepository) {

    /**
     * Invokes the use case to fetch country details by delegating the call to the repository.
     *
     * @return A list of country details retrieved from the repository.
     */
    suspend operator fun invoke() = countryRepository.getCountryDetails()
}
