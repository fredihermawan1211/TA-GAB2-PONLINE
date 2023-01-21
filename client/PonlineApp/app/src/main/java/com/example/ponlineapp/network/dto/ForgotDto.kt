package com.example.ponlineapp.network.dto

import com.google.gson.annotations.SerializedName

class ForgotDto(@SerializedName("success") val succes: String,
                @SerializedName("message") val message: String)