package com.example.walmartcodingofnitya.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder().apply {
        addInterceptor(loggingInterceptor)
    }.build()

    val retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl(RemoteConstants.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            client(client)
        }.build()
    }
}