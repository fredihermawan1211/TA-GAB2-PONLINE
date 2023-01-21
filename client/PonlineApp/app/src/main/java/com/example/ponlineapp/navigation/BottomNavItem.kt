package com.example.ponlineapp.navigation


import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route:String,
)
data class ItineraryDay(
    val day: String,
    val date:Int,
    val month: Int,
)
data class Testdate(
    val date: String,
)

