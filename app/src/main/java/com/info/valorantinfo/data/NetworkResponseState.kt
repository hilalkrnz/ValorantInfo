package com.info.valorantinfo.data

sealed class NetworkResponseState<out T : Any> {
    object Loading : NetworkResponseState<Nothing>()
    data class Success<out T : Any>(val result: T?) : NetworkResponseState<T>()
    data class Error(val exception : Exception) : NetworkResponseState<Nothing>()
}
