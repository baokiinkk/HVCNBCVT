package com.baokiiin.hvcnbcvt.data.respository

import com.baokiiin.hvcnbcvt.data.api.ApiService
import com.baokiiin.hvcnbcvt.data.model.LoginUser
import com.baokiiin.hvcnbcvt.data.model.Response
import com.baokiiin.hvcnbcvt.data.model.ResponseError
import com.baokiiin.hvcnbcvt.data.model.Users
import retrofit2.HttpException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun login(login: LoginUser): Response<Users> =
        try {
           val response =  apiService.login(login)
            Response.success(response)
        } catch (cause: HttpException) {
            val mess = cause.response()?.errorBody()?.string()
            val status = cause.response()?.code()
            Response.error(status?.let { ResponseError(it,mess.toString()) })
        }
}