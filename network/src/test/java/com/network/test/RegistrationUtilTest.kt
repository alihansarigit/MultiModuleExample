package com.network.test

import com.google.common.truth.Truth.assertThat
import com.network.response.users.Users
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RegistrationUtilTest{


    @Test
    fun `first username equals to response`() = runBlocking {
             delay(200)
             val users: Users? = MockService.getInstance().getUsers()
            assertThat(users!!.get(0)?.name).isEqualTo("name 1")
    }

    @Test
    fun `first username not equals to response`() = runBlocking {
        delay(200)
        val users: Users? = MockService.getInstance().getUsers()
        assertThat(users!!.get(0)?.name).isNotEqualTo("name 2")
    }

//    @Test
//    fun `empty username return false`(){
//        val result = RegistrationUtil.validateRegistrationInput(
//            "",
//            "123",
//            "123"
//        )
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun deneme() = runBlocking {
//        var key = fakeApiCall()
//        assertThat("123").isEqualTo(key)
//    }
//
//    private suspend fun fakeApiCall():String {
//        var apiKey = ""
//        delay(100)
//        apiKey = "123"
//        return apiKey
//    }
//
//    @Test
//    fun `valid user and correct password return true`(){
//        val result = RegistrationUtil.validateRegistrationInput(
//            "Selin",
//            "123",
//            "123"
//        )
//        assertThat(result).isTrue()
//    }
//
//    @Test
//    fun `username already taken return false`(){
//        val result = RegistrationUtil.validateRegistrationInput(
//            "Ali",
//            "123",
//            "123"
//        )
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun `empty password return false`(){
//        val result = RegistrationUtil.validateRegistrationInput(
//            "Selin",
//            "",
//            ""
//        )
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun `password not is same return false`(){
//        val result = RegistrationUtil.validateRegistrationInput(
//            "Selin",
//            "123",
//            "1234"
//        )
//        assertThat(result).isFalse()
//    }
//
//    @Test
//    fun `password less than 2 digits return false`(){
//        val result = RegistrationUtil.validateRegistrationInput(
//            "Selin",
//            "asdfasdf1",
//            "asdfadsf1"
//        )
//        assertThat(result).isFalse()
//    }
}