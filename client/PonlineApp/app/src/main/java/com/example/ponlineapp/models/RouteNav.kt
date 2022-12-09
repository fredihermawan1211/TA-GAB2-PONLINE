package com.example.ponlineapp.models

sealed class RouteNav(val route: String)
{
    object Register : RouteNav("Register")
    object Login : RouteNav("Login")
    object ForgotPassword : RouteNav("ForgotPassword")
    object ConfirmPassword : RouteNav("ConfirmPassword")
    object Dashboard : RouteNav("Dashboard")
    object SplashScreen : RouteNav("SplashScreen")

}

