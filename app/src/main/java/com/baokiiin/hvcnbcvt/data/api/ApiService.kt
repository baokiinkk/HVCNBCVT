package com.baokiiin.hvcnbcvt.data.api

import com.baokiiin.hvcnbcvt.data.model.LoginUser
import com.baokiiin.hvcnbcvt.data.model.Users
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users/login")
    suspend fun login(@Body loginUser: LoginUser): Users
}