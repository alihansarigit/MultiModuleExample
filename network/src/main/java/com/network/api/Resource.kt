package com.network.api

sealed class ResponseApi<T>() {
    data class loading<T>(val data:T? = null,val status: Status = Status.LOADING):ResponseApi<T>()
    data class success<T>(val data:T,val status: Status = Status.SUCCESS):ResponseApi<T>()
    data class error<T>(val data:T? = null, var message:String="Error",val status: Status = Status.ERROR):ResponseApi<T>()
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}