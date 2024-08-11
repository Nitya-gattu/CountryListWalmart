package com.example.walmartcodingofnitya.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin
import com.example.walmartcodingofnitya.domain.usecase.CountryUseCase
import kotlinx.coroutines.launch

class CountryViewModel(
    private val countryUseCase: CountryUseCase
) : ViewModel() {

    private val _countryDataList = MutableLiveData<List<CountryListDoamin>>()
    val countryDataList: LiveData<List<CountryListDoamin>> = _countryDataList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        getCountryDataList()
    }

    private fun getCountryDataList() {
        viewModelScope.launch {
            try {
                val result = countryUseCase.invoke()
                _countryDataList.postValue(result)
            } catch (e: Exception) {
                _error.postValue(e.message)
            }
        }
    }
}