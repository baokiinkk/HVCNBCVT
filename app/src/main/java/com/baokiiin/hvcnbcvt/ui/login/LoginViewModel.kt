package com.baokiiin.hvcnbcvt.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baokiiin.hvcnbcvt.R
import com.baokiiin.hvcnbcvt.data.model.LoginUser
import com.baokiiin.hvcnbcvt.data.model.Users
import com.baokiiin.hvcnbcvt.data.respository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(private val repo: Repository):ViewModel() {
    val img = R.drawable.loginscreen
    val logo = R.drawable.logoptit
    var email = ""
    var password = ""
    var user: MutableLiveData<Users?> = MutableLiveData(null)

    fun login(){
        val loginUser = LoginUser(email,password)
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            user.postValue(Users())
        }
    }
}