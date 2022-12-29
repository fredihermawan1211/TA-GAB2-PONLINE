package com.example.ponlineapp.network.repository

import com.example.ponlineapp.network.dto.LoginDto
import com.example.ponlineapp.network.dto.Register
import com.example.ponlineapp.network.dto.RegisterDto
import com.example.ponlineapp.network.dto.TokenDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun getLogin(@Body loginDto: LoginDto) : Response<TokenDto>

    @POST("auth/signup")
    suspend fun getRegister(@Body register: Register) : Response<RegisterDto>
}