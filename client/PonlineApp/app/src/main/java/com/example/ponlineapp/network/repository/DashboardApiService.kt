package com.example.ponlineapp.network.repository

import com.example.ponlineapp.network.dto.JadwalList
import com.example.ponlineapp.network.dto.TokenDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DashboardApiService {
    @GET("/jadwal")
    suspend fun getjadwal(@Header("Authorization") Bearer: TokenDto ) : Call<List<JadwalList>>

//    @POST("auth/login")
//    suspend fun getLogins(@Body loginDto: LoginDto) : Response<TokenDto>
}