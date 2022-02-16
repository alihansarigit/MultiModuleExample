package com.network.api

import com.network.response.users.Users
import retrofit2.Response

class AppService:EndpointInterface {

    //TODO Singleton classa çevir

    //
    override suspend fun getUsers(): Users {
        return RetrofitClient.retrofitInstance.getUsers()
    }
}
