package com.example.walmartcodingofnitya.data.mapper

import com.example.walmartcodingofnitya.data.dto.CountryResponseEntity
import com.example.walmartcodingofnitya.data.dto.Currency
import com.example.walmartcodingofnitya.data.dto.Language
import com.example.walmartcodingofnitya.domain.dto.CountryListDoamin

object CountryMapper : IMapper<CountryResponseEntity, CountryListDoamin> {
    override fun mapToDomain(type: CountryResponseEntity): CountryListDoamin {
        return CountryListDoamin(
            name = type.name,
            region = type.region,
            code = type.code,
            capital = type.capital
        )
    }

    override fun mapToEntity(type: CountryListDoamin): CountryResponseEntity {
        return CountryResponseEntity(
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