package com.network.api

import com.network.response.users.Users
import retrofit2.Response

class AppService private constructor() :EndpointInterface {

   
    companion object{
        private var appService:AppService = AppService()

        fun getInstance():AppService{
            return appService
        }
    }
    override suspend fun getUsers(): Users {
        return RetrofitClient.retrofitInstance.getUsers()
    }
}
