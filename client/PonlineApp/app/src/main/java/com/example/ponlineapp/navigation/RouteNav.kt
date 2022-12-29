package com.example.ponlineapp.navigation

sealed class RouteNav(val route: String)
{
    object Register : RouteNav("Register")
    object Login : RouteNav("Login")
    object ForgotPassword : RouteNav("ForgotPassword")
    object ConfirmPassword : RouteNav("ConfirmPassword")
    object Dashboard : RouteNav("Dashboard")
    object SplashScreen : RouteNav("SplashScreen")
    object  Home : RouteNav("Home")

    companion object{
        fun getStartDestination() = Login.route
    }
}

