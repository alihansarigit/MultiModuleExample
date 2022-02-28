package com.network.test

import com.network.api.EndpointInterface
import com.network.response.users.Users
import com.network.response.users.UsersItem


class MockService private constructor() : EndpointInterface {

    companion object{
        private var mockService: MockService = MockService()


        fun getInstance(): MockService {
            return mockService
        }
    }

    override suspend fun getUsers(): Users {
//        val jsonFile = getResource("test/data.json").file
//        val gson:Gson = GsonBuilder().create()
//        val loader = ClassLoader.getSystemClassLoader()

//        val json: String? = Files.lines(Paths.get(loader.getResource("test/data.json").toURI()))
//            .parallel()
//            .collect(Collectors.joining())
//        return gson.fromJson(json,Users::class.java)

        val list = Users().apply {
            add(UsersItem("a","f","f","name 1"))
            add(UsersItem("a","fs","fs","fs"))
            add(UsersItem("ax","fsx","fsx","fsx"))
        }

        return list
    }
}