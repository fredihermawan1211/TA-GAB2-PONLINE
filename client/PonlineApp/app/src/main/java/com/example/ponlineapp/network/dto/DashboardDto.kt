package com.example.ponlineapp.network.dto

import com.google.gson.annotations.SerializedName

data class Mytuken(
    val tuken:String
)
data class Jadwal(@SerializedName("id")
                  val id:Int,
                  val dateTodo:String)
data class JadwalList(@SerializedName("jadwal")
                      var jadwal: List<Jadwal>)