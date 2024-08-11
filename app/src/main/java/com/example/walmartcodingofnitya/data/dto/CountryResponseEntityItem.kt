package com.example.walmartcodingofnitya.data.dto

import com.google.gson.annotations.SerializedName

data class CountryResponseEntityItem(
    @SerializedName("capital") val capital: String,
    @SerializedName("code") val code: String,
    @SerializedName("currency") val currency: Currency,
    @SerializedName("demonym") val demonym: String,
    @SerializedName("flag") val flag: String,
    @SerializedName("language") val language: Language,
    @SerializedName("name") val name: String,
    @SerializedName("region") val region: String
)