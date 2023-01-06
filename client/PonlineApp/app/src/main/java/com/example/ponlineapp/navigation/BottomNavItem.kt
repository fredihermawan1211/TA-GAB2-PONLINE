<<<<<<<< HEAD:client/PonlineApp/app/src/main/java/com/example/ponlineapp/navigation/ModelDashboard.kt
========
package com.example.ponlineapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
>>>>>>>> b3023c6b63aea92496bf95f43d4623f9172d0082:client/PonlineApp/app/src/main/java/com/example/ponlineapp/navigation/BottomNavItem.kt
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

