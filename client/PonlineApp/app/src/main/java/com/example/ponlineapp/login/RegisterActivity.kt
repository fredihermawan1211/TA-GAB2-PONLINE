package com.example.ponlineapp.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.R
import com.example.ponlineapp.navigation.RouteNav


@Composable
fun TopBarRegister(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 35.dp, bottom = 10.dp)) {
        Text(text = stringResource(id = R.string.daftar),
//             style = MaterialTheme.typography.bodyLarge
            fontSize = 28. sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun Registerform(navController: NavHostController)
{
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box{
        BackgroundImage()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TopBarRegister()
            Card(elevation = 5.dp) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text("Nama", color = Color.Gray) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors
                        (
                        backgroundColor =  Color.White,
                        textColor = Color.Gray,
                        //untuk menghilangkan underline
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                    ),
                    singleLine = true
                )
            }

            Card(elevation = 5.dp) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("Email", color = Color.Gray) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors
                        (
                        backgroundColor =  Color.White,
                        textColor = Color.Gray,
                        //untuk menghilangkan underline
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                    ),
                    singleLine = true,

                    )
            }

            Card(elevation = 5.dp) {
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Masukkan Password", color = Color.Gray) },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors
                        (
                        backgroundColor = Color.White,
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent

                    ),
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        // Localized description for accessibility services
                        val description = if (passwordVisible) "Hide password" else "Show password"

                        // Toggle button to hide or display password
                        IconButton(onClick = {passwordVisible = !passwordVisible}){
                            Icon(imageVector  = image, description)
                        }
                    }
                )
            }

//            Card(elevation = 5.dp) {
//                TextField(
//                    value = password,
//                    onValueChange = { password = it },
//                    placeholder = { Text("Konfirmasi Password", color = Color.Gray) },
//                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//                    modifier = Modifier .fillMaxWidth(),
//                    shape = RoundedCornerShape(15.dp),
//                    colors = TextFieldDefaults.textFieldColors
//                        (
//                        backgroundColor = Color.White,
//                        textColor = Color.Gray,
//                        disabledTextColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        focusedIndicatorColor = Color.Transparent
//                    ),
//                    trailingIcon = {
//                        val image = if (passwordVisible)
//                            Icons.Filled.Visibility
//                        else Icons.Filled.VisibilityOff
//
//                        // Localized description for accessibility services
//                        val description = if (passwordVisible) "Hide password" else "Show password"
//
//                        // Toggle button to hide or display password
//                        IconButton(onClick = {passwordVisible = !passwordVisible}){
//                            Icon(imageVector  = image, description)
//                        }
//                    }
//                )
//            }
            Button( onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
            ) {
                Text(text = "Daftar", fontWeight = FontWeight.Bold, color = Color.White)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Sudah Punya Akun?")
                TextButton(onClick = { navController.navigate(route = RouteNav.Login.route) }) {
                    Text(text = "Masuk", fontWeight = FontWeight.Bold, color = colorResource(R.color.blue_100))
                }
            }
            //panggil fungsi logo dari page login
            Icon(painter = painterResource(R.drawable.logo_ponline),
                contentDescription = stringResource(id = R.string.logo),
                tint = colorResource(id = R.color.blue_100),
                modifier = Modifier
                    .size(180.dp)
                    .padding(top = 5.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestingRegister(){
    val navController = rememberNavController()
    Registerform(navController = navController)
}



