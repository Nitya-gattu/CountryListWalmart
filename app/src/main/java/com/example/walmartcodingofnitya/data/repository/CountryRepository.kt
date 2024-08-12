package com.example.walmartcodingofnitya.data.repository

import com.example.walmartcodingofnitya.data.mapper.CountryMapper
import com.example.walmartcodingofnitya.data.remote.CountryApiService
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin
import com.example.walmartcodingofnitya.domain.repository.ICountryRepository

/**
 * Repository class responsible for fetching country data from a remote API.
 *
 * @property apiService The service used to make API calls to fetch country data.
 */
class CountryRepository(
    private val apiService: CountryApiService = CountryApiService.getInstance()
) : ICountryRepository {

    /**
     * Fetches the list of country details from the API, maps the data to the domain model,
     * and returns it. Throws an exception if the API call is unsuccessful.
     *
     * @return A list of country details mapped to the domain model.
     * @throws Exception if the API call fails or the response is not successful.
     */
    override suspend fun getCountryDetails(): List<CountryListDoamin> {
        // Make the API call to get the country list.
        val response = apiService.getCountryList()

        // Check if the response is successful.
        if (response.isSuccessful) {
            // Get the body of the response or return an empty list if the body is null.
            val countryList = response.body() ?: emptyList()

            // Map the response data to the domain model and return the list.
            return countryList.map { CountryMapper.mapToDomain(it) }
        } else {
            // Throw an exception if the response is not successful.
            throw Exception("Failed to fetch country details")
        }
    }
}
