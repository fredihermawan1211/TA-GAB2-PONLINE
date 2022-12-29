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
    object Verify : RouteNav("Verify")
    object NavigationScreen : RouteNav("NavigationLogin")

    companion object{
        fun getStartDestination(): String = Login.route

    }
}

