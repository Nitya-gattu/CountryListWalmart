package com.example.walmartcodingofnitya.data.remote

import com.example.walmartcodingofnitya.data.dto.CountryResponseEntity
import retrofit2.Response
import retrofit2.http.GET

interface CountryApiService {
    @GET(RemoteConstants.END_POINT)
    suspend fun getCountryList() : Response<List<CountryResponseEntity>>

    companion object{
        private lateinit var apiService: CountryApiService
        fun getInstance():CountryApiService{
            if(!::apiService.isInitialized){
                apiService = RetrofitClient.retrofit.create(CountryApiService::class.java)
            }
            return apiService
        }
    }
}