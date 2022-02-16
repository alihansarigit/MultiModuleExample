package com.network.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.network.api.AppService
import com.network.api.ResponseApi
import com.network.api.RetrofitClient
import com.network.response.users.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class AppService: ViewModel() {

    private val TAG: String = "HomeViewModel"
//    private val _userList = MutableLiveData<ResponseApi<Users>>()
//    val userList: LiveData<ResponseApi<Users>> get() = _userList

    fun getUsers(): LiveData<ResponseApi<Users>>{
        return liveData(Dispatchers.IO) {
            emit(ResponseApi.loading())
            try {
                emit(ResponseApi.success(data = AppService().getUsers()))
            } catch (exception: Exception) {
                emit(ResponseApi.error<Users>(message = exception.message ?: "Error Occurred!"))
            }
        }
    }
}