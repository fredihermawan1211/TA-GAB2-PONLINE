package com.example.ponlineapp.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.dashboard.HomeScreen
import com.example.ponlineapp.dashboard.MainPage
import com.example.ponlineapp.login.components.SplashScreen
import com.example.ponlineapp.navigation.RouteNav
import com.example.ponlineapp.network.dto.TokenDto
import com.example.ponlineapp.profil.EditProfileScreen
import com.example.ponlineapp.profil.ProfileScreen
import com.example.ponlineapp.viewModel.LoginViewModel
import java.lang.reflect.Modifier


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

        composable(RouteNav.Register.route){
            if (viewModel.isSuccessLoading.value){
                LaunchedEffect(key1 = Unit){
                    navController.navigate(route = RouteNav.Verify.route){
                        popUpTo(route = RouteNav.Login.route)
                    }
                }
            }
            else{
                Registerform(
                    navController = navController,
                    loadingProgressBar = loadingProgressBar,
                    onclickRegister = viewModel::register
                )
            }
        }

        composable(RouteNav.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }
        composable(RouteNav.ConfirmPassword.route + "/{email}"){ backStackEntry ->
            val email = backStackEntry.arguments?.getString("email")
            ConfirmPassword(navController = navController, email)
        }
        composable(RouteNav.Home.route){
//            HomeScreen(navHostController = navController)
//            MainPage(navController = navController)
            MainPage()
        }
        composable(RouteNav.Verify.route){
            verifyPage(navController = navController)
        }
        composable(RouteNav.SplashScreen.route){
            SplashScreen(navHostController = navController)
        }
        composable(RouteNav.Profile.route){
            ProfileScreen(navController = navController)
        }
        composable(RouteNav.Profile.route){
            EditProfileScreen(navController = navController)
        }
    }
}