package com.abiodundotdev.pulavest.domain.responses

sealed class GetProductsResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : GetProductsResponse<T>(data)
    class Error<T>(message: String, data: T? = null) : GetProductsResponse<T>(data, message)
    class Loading<T> : GetProductsResponse<T>()
}