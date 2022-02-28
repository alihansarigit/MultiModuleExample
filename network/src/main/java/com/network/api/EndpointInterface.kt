package com.network.api

import com.network.response.users.Users
import retrofit2.http.GET
import retrofit2.http.Headers

interface EndpointInterface {
    @Headers("Accept-Encoding: identity")
    @GET("users")
    suspend fun getUsers(): Users
}
