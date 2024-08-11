package com.example.walmartcodingofnitya.data.mapper

import com.example.walmartcodingofnitya.data.dto.CountryResponseEntityItem
import com.example.walmartcodingofnitya.data.dto.Currency
import com.example.walmartcodingofnitya.data.dto.Language
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin

object CountryMapper : IMapper<CountryResponseEntityItem, CountryListDoamin> {
    override fun mapToDomain(type: CountryResponseEntityItem): CountryListDoamin {
        return CountryListDoamin(
            name = type.name,
            region = type.region,
            code = type.code,
            capital = type.capital
        )
    }

    override fun mapToEntity(type: CountryListDoamin): CountryResponseEntityItem {
        return CountryResponseEntityItem(
            name = type.name,
            capital = type.capital,
            code = type.code,
            currency = Currency("", "", ""),
            demonym = "",
            flag = "",
            language = Language("", "", "", ""),
            region = "",
        )
    }
}