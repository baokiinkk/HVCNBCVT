package com.baokiiin.hvcnbcvt.data.model

data class Response<out T>(val status: Status, val data: T?, val error: ResponseError?) {
    companion object {
        fun <T> success(data: T?): Response<T>{
            return Response(Status.SUCCESS, data, null)
        }
        fun <T> error(error: ResponseError?): Response<T>{
            return Response(Status.ERROR, null, error)
        }
    }
}
enum class Status {
    SUCCESS,
    ERROR
}