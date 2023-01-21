package com.example.ponlineapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.ponlineapp.login.NavigationScreen
import com.example.ponlineapp.ui.theme.PonlineAppTheme
import com.example.ponlineapp.viewModel.LoginViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PonlineAppTheme {
                NavigationScreen(viewModel = viewModel)
            }
        }
    }
}


