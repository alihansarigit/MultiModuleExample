package com.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {
    companion object{
        var baseURL:String = "https://62061933161670001741bf08.mockapi.io/api/"

        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseURL)
            .build()

        val retrofitInstance: Endpoint by lazy {
            retrofit.create(Endpoint::class.java)
        }
    }
}