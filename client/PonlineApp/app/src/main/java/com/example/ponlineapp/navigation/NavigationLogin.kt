package com.example.ponlineapp.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.dashboard.Home
import com.example.ponlineapp.navigation.RouteNav
import com.example.ponlineapp.viewModel.LoginViewModel


@Composable
fun NavigationScreen(viewModel: LoginViewModel) {

    val navController = rememberNavController()
    val loadingProgressBar = viewModel.progressBar.value
    val imageError = viewModel.imageErrorAuth.value


    NavHost(
        navController = navController,
        startDestination = RouteNav.getStartDestination()
    ) {
        composable(RouteNav.Login.route) {
            if (viewModel.isSuccessLoading.value) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(route = RouteNav.Home.route) {
                        popUpTo(route = RouteNav.Login.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                Loginform(
                    navController = navController,
                    loadingProgressBar = loadingProgressBar,
                    onclickLogin = viewModel::login,
                    imageError = imageError
                )
            }
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
        composable(RouteNav.Home.route){
            Home(navController = navController)
        }

        
    }
}