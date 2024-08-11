package com.example.walmartcodingofnitya.repository

import com.example.walmartcodingofnitya.data.remote.CountryApiService
import com.example.walmartcodingofnitya.data.repository.CountryRepository
import com.example.walmartcodingofnitya.utils.MockData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class CountryListRepositoryTest {

    private lateinit var repository: CountryRepository
    private val apiService: CountryApiService = mockk<CountryApiService>()

    @Before
    fun setUp() {
        repository = CountryRepository(apiService)
    }

    @Test
    fun `GIVEN success data WHEN getCountryDetails is invoked THEN returns mapped result`() {
        val mockDataResponse = MockData.mockCountryResponseList

        coEvery { apiService.getCountryList() } returns Response.success(mockDataResponse)

        val result = runBlocking {
            repository.getCountryDetails()
        }

        assertEquals(mockDataResponse[0].name, result[0].name)
        assertEquals(mockDataResponse[0].region, result[0].region)
        assertEquals(mockDataResponse[0].code, result[0].code)
        assertEquals(mockDataResponse[0].capital, result[0].capital)
    }

    @Test(expected = java.lang.AssertionError::class)
    fun `GIVEN API failure WHEN getCountryDetails is invoked THEN throws exception`(){
        coEvery { apiService.getCountryList() }  throws AssertionError(ERROR_MSG)

        val exception = runBlocking {
            repository.getCountryDetails()
        }

        assertEquals(ERROR_MSG, exception)
    }

    companion object{
        const val ERROR_MSG = "Failed to fetch country details"
    }
}