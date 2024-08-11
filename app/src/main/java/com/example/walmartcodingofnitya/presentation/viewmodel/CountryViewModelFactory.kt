package com.example.walmartcodingofnitya.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.walmartcodingofnitya.domain.usecase.CountryUseCase

class CountryViewModelFactory(
    private val countryUseCase: CountryUseCase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(countryUseCase) as T
    }
}