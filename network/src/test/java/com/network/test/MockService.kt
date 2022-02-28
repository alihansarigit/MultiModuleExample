package com.network.test

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.network.api.EndpointInterface
import com.network.response.users.Users
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors


class MockService private constructor() : EndpointInterface {

    companion object{
        private var mockService: MockService = MockService()


        fun getInstance(): MockService {
            return mockService
        }
    }
    @Throws(Exception::class)
    fun readTextStream(inputStream: InputStream): String? {
        val result = ByteArrayOutputStream()
        val buffer = ByteArray(1024)
        var length: Int
        while (inputStream.read(buffer).also { length = it } != -1) {
            result.write(buffer, 0, length)
        }
        return result.toString("UTF-8")
    }

    private fun getData():InputStream{
       return this.javaClass.classLoader.getResourceAsStream("test_data/data.json")

    }
    override suspend fun getUsers(): Users {
        val json = readTextStream(getData())
        val gson: Gson = GsonBuilder().create()

        return gson.fromJson(json,Users::class.java)
    }
}