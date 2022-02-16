package com.network.api

import com.network.response.users.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface EndpointInterface {
    @GET("users")
    suspend fun getUsers(): Users
}