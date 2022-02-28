package com.network.viewmodel

import androidx.lifecycle.*
import com.network.api.AppService
import com.network.api.ResponseApi
import com.network.response.users.Users
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

open class AppService: ViewModel() {
    private val TAG: String = "HomeViewModel"
//    private val _userList = MutableLiveData<ResponseApi<Users>>()
//    val userList: LiveData<ResponseApi<Users>> get() = _userList

    fun getUsers(): LiveData<ResponseApi<Users>> {
        return liveData(Dispatchers.IO) {
            emit(ResponseApi.loading())
            try {
                emit(ResponseApi.success(data = AppService.getInstance().getUsers()))
            } catch (exception: Exception) {
                emit(ResponseApi.error<Users>(message = exception.message ?: "Error Occurred!"))
            }
        }
    }
}