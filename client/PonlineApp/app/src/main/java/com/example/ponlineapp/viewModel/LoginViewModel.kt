package com.example.ponlineapp.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ponlineapp.network.dto.LoginDto
import com.example.ponlineapp.network.dto.Register
import com.example.ponlineapp.network.repository.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("StaticFieldLeak")
class LoginViewModel : ViewModel() {
    val isSuccessLoading = mutableStateOf(value = false)
    val isSuccessLoadingRegister = mutableStateOf(value = false)
    val isSuccessLoadingForgot = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    private val loginRequestLiveData = MutableLiveData<Boolean>()
    private val registerRequestLiveData = MutableLiveData<Boolean>()
    private val forgotRequestLiveData = MutableLiveData<Boolean>()

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getLogin(LoginDto(email = email, password = password))


                if (responseService.isSuccessful) {
                    delay(1500L)
                    isSuccessLoading.value = true
                    responseService.body()?.let { tokenDto ->
                        Log.d("Logging", "Response Token: ${tokenDto.accessToken}")
                    }

                } else {
                    responseService.errorBody()?.let { error ->
                        imageErrorAuth.value = true
                        delay(1500L)
                        imageErrorAuth.value = false
                        error.close()
                    }
                }


                loginRequestLiveData.postValue(responseService.isSuccessful)
                progressBar.value = false
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
                progressBar.value = false
            }
        }
    }

    fun register(name: String, email: String, password: String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getRegister(Register(nama = name, email = email, password = password))

                if (responseService.isSuccessful){
                    delay(1000L)
                    isSuccessLoadingRegister.value = true
                    responseService.body()?.let {  registerDto ->
                        Log.d("verifikasi register", "Response : ${registerDto.succesVerify}")
                    }
                }else {
                    responseService.errorBody()?.let { error ->
                        imageErrorAuth.value = true
                        delay(1500L)
                        imageErrorAuth.value = false
                        error.close()
                    }
                }
                registerRequestLiveData.postValue(responseService.isSuccessful)
                progressBar.value = false
            }
            catch (e: Exception) {
                Log.d("verifikasi register", "Error Authentication", e)
                progressBar.value = false
            }
        }

    }

    fun ForgotPassword(email: String){
        viewModelScope.launch(Dispatchers.IO){
            try {
                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.forgotPassword(email)

                if (responseService.isSuccessful){
                    delay(1000L)
                    isSuccessLoadingForgot.value = true
                    responseService.body()?.let {  forgotPassword ->
                        Log.d("Message", "Response : ${forgotPassword}")
                    }
                }else {
                    responseService.errorBody()?.let { error ->
                        Log.d("message", "Response : $error")
                    }
                }
                forgotRequestLiveData.postValue(responseService.isSuccessful)
                progressBar.value = false
            }catch (e: Exception) {
                Log.d("Message", "email  Terkirim", e)
                isSuccessLoadingForgot.value = true
                progressBar.value = false
            }
        }
    }
}

