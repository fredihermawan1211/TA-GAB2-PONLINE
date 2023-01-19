package com.example.ponlineapp.navigation

sealed class RouteNav(val route: String)
{
    object Register : RouteNav("Register")
    object Login : RouteNav("Login")
    object ForgotPassword : RouteNav("ForgotPassword")
    object ConfirmPassword : RouteNav("ConfirmPassword")
    object Home : RouteNav("Home")
    object SplashScreen : RouteNav("SplashScreen")
    object Verify : RouteNav("Verify")
    object NavigationScreen : RouteNav("NavigationLogin")
    object Profile : RouteNav("NavigationProfile")
    companion object{
        fun getStartDestination(): String = SplashScreen.route

    }
}

