package com.example.ponlineapp.network.dto

import com.google.gson.annotations.SerializedName

class LoginDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

class Register(
    @SerializedName("name") val nama: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

