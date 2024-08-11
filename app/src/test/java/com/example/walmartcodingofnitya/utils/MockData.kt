package com.example.walmartcodingofnitya.utils

import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin

object MockData {
    val mockCountryList = listOf(
        CountryListDoamin(
            region = "AS",
            code = "AF",
            name = "Afghanistan",
            capital = "kabul"
        ),
        CountryListDoamin(
            region = "EU",
            code = "AL",
            name = "Albania",
            capital = "Tirana"
        )
    )
}