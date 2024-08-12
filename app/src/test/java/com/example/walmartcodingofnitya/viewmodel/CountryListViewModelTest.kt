package com.example.walmartcodingofnitya.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin
import com.example.walmartcodingofnitya.domain.usecase.CountryUseCase
import com.example.walmartcodingofnitya.presentation.viewmodel.CountryViewModel
import com.example.walmartcodingofnitya.utils.MockData
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CountryListViewModelTest {
    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val useCase = mockk<CountryUseCase>()
    private val successObserver = mockk<Observer<List<CountryListDoamin>>>(relaxed = true)
    private val errorObserver = mockk<Observer<String>>(relaxed = true)
    private lateinit var viewModel : CountryViewModel

    @Before
    fun setUp(){
        viewModel = CountryViewModel(useCase)
    }

    @Test
    fun `GIVEN success data WHEN getCountryList is invoked THEN returns success result`(){
        val mockData = MockData.mockCountryList

        coEvery { useCase.invoke() } returns mockData

        viewModel.apply {
            countryDataList.observeForever(successObserver)
            getCountryDataList()

            coVerify {
                useCase.invoke()
                successObserver.onChanged(mockData)
            }
        }
    }

    @Test
    fun `GIVEN success data WHEN getCountryList is invoked THEN returns empty result`(){
        val emptyMockData = emptyList<CountryListDoamin>()

        coEvery { useCase.invoke() } returns emptyMockData

      viewModel.apply {
          countryDataList.observeForever(successObserver)
          getCountryDataList()
          assertEquals(emptyMockData, countryDataList.value )
      }
    }

    @Test(expected = java.lang.AssertionError::class)
    fun `GIVEN no internet data WHEN getCountryList is invoked THEN returns exception result`(){
        coEvery { useCase.invoke() } throws AssertionError(ERROR)

        viewModel.apply {
            error.removeObserver(errorObserver)
            getCountryDataList()

            assertEquals(ERROR, error.value )
        }
    }

    @After
    fun tearDown(){
        viewModel.apply {
            if(countryDataList.hasActiveObservers()){
                countryDataList.removeObserver(successObserver)
            }
            if(error.hasActiveObservers()){
                error.removeObserver(errorObserver)
            }
        }
    }

    companion object{
        const val ERROR = "failure"
    }
}