package com.example.walmartcodingofnitya.utils

import com.example.walmartcodingofnitya.data.dto.CountryResponseEntity
import com.example.walmartcodingofnitya.data.dto.Currency
import com.example.walmartcodingofnitya.data.dto.Language
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

    val mockCountryResponseList = listOf(
        CountryResponseEntity(
            capital = "Kabul",
            code = "AF",
            currency = Currency("AFN", "Afghan afghani" , ""),
            demonym = "Afghan",
            flag = "https://restcountries.com/v2/af/flag",
            language = Language("Pashto", name = "ps", iso6392 =  "", nativeName = ""),
            name = "Afghanistan",
            region = "Asia"
        ),
        CountryResponseEntity(
            capital = "Tirana",
            code = "AL",
            currency = Currency("ALL", "Albanian lek", ""),
            demonym = "Albanian",
            flag = "https://restcountries.com/v2/al/flag",
            language = Language("Albanian", name = "sq", iso6392 =  "", nativeName = ""),
            name = "Albania",
            region = "Europe"
        )
    )
}