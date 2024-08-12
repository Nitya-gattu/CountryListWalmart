package com.example.walmartcodingofnitya.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin
import com.example.walmartcodingofnitya.domain.usecase.CountryUseCase
import kotlinx.coroutines.launch

/**
 * ViewModel class for managing the data related to countries.
 *
 * @property countryUseCase The use case responsible for fetching the country data.
 */
class CountryViewModel(
    private val countryUseCase: CountryUseCase
) : ViewModel() {

    // LiveData that holds the list of country data to be observed by the UI.
    private val _countryDataList = MutableLiveData<List<CountryListDoamin>>()
    val countryDataList: LiveData<List<CountryListDoamin>> = _countryDataList

    // LiveData that holds the error messages to be observed by the UI.
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    // Initializer block to load country data when the ViewModel is created.
    init {
        getCountryDataList()
    }

    /**
     * Fetches the list of countries using the countryUseCase and updates the
     * LiveData with the result or an error message.
     */
    fun getCountryDataList() {
        viewModelScope.launch {
            try {
                // Fetch the list of countries from the use case.
                val result = countryUseCase.invoke()

                // Post the fetched list to the LiveData.
                _countryDataList.postValue(result)
            } catch (e: Exception) {
                // In case of an error, post the error message to the LiveData.
                _error.postValue(e.message)
            }
        }
    }
}