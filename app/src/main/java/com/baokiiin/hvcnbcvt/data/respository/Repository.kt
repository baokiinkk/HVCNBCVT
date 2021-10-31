package com.baokiiin.hvcnbcvt.data.respository

import com.baokiiin.hvcnbcvt.data.model.LoginUser
import com.baokiiin.hvcnbcvt.data.model.Response
import com.baokiiin.hvcnbcvt.data.model.Users
import okhttp3.ResponseBody
import javax.inject.Singleton


@Singleton
interface Repository{
   suspend fun login(login: LoginUser): Response<Users>
}