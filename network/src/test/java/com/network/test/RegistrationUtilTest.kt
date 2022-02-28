package com.network.test

import com.google.common.truth.Truth.assertThat
import com.network.response.users.Users
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.InputStream

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
}