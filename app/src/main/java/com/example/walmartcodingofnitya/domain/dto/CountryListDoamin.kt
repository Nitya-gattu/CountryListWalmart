package com.example.walmartcodingofnitya.domain.dto

import com.google.gson.annotations.SerializedName

data class CountryListDoamin(
    @SerializedName("capital") val capital: String,
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("region") val region: String
)
