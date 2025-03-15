package com.example.foodhub

sealed class DataState<T>(
    var massage: String? = null,
    var data: T? =null
) {
    class Loding<T>: DataState<T>()
    class Suscess<T>(JData:T?): DataState<T>(data = JData)
    class Error<T>(massage: String): DataState<T>(massage)
}