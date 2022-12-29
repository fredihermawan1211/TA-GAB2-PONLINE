package com.example.ponlineapp.login

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.dashboard.HomeAppBar
import com.example.ponlineapp.dashboard.NavHostContainer
import com.example.ponlineapp.models.RouteNav
import com.example.ponlineapp.dashboard.PageTest


@Preview(showBackground = true)
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RouteNav.Login.route,
    ) {
        composable(RouteNav.Login.route) {
            Loginform(navController = navController)
        }

        composable(RouteNav.Register.route) {
            Registerform(navController = navController)
        }

        composable(RouteNav.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }
        composable(RouteNav.ConfirmPassword.route + "/{email}"){ backStackEntry ->

            val email = backStackEntry.arguments?.getString("email")
            ConfirmPassword(navController = navController, email)
        }
        composable(RouteNav.Dashboard.route){
//            PageTest(navController = navController)
            PageTest() //fortestpreview
        }

        
    }
}