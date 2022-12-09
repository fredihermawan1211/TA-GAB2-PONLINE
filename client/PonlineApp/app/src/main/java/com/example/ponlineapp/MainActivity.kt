package com.example.ponlineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.dashboard.BottomNavigationBar
import com.example.ponlineapp.dashboard.HomeAppBar
import com.example.ponlineapp.dashboard.NavHostContainer
import com.example.ponlineapp.login.BackgroundImage
import com.example.ponlineapp.login.Loginpage
import com.example.ponlineapp.ui.theme.PonlineAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PonlineAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//
//                ) {
//
//                }
                // remember navController so it does not
                // get recreated on recomposition
//                val navController = rememberNavController()
//
//                androidx.compose.material.Surface(color = Color.White) {
//                    // Scaffold Component
//                    Scaffold(
//                        // Topbar
//                        topBar = {
//                            HomeAppBar(
//                                backgroundColor = colorResource(R.color.blue_100),
//                                modifier = Modifier.fillMaxWidth()
//                            )
//                        },
//                        // Bottom navigation
//                        bottomBar = {
//                            BottomNavigationBar(navController = navController)
//                        }, content = { padding ->
//                            // Navhost: where screens are placed
//                            NavHostContainer(navController = navController, paddingValues = padding)
//                        }
//                    )
//                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Background(){

}