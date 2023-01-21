package com.example.ponlineapp.network.repository

import com.example.ponlineapp.network.dto.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {
    @POST("authentication/login")
    suspend fun getLogin(@Body loginDto: LoginDto) : Response<TokenDto>

    @POST("authentication/signup")
    suspend fun getRegister(@Body register: Register) : Response<RegisterDto>
    @GET("authentication/forgotpassword")
    suspend fun forgotPassword(@Query("email") email: String) : Response<ForgotDto>
}

