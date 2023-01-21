package com.example.ponlineapp.login

import android.annotation.SuppressLint
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.R
import com.example.ponlineapp.login.components.ErrorImageAuth
import com.example.ponlineapp.login.components.ProgressBarLoading
import com.example.ponlineapp.navigation.RouteNav
import com.example.ponlineapp.viewModel.LoginViewModel


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

@SuppressLint("UnrememberedMutableState")
@Composable
fun Registerform(
    navController: NavHostController,
    loadingProgressBar: Boolean,
    onclickRegister: (nama: String, email: String, password: String) -> Unit,
    imageError: Boolean
)
{
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordValidate by remember { mutableStateOf("")}
    var erorMessage by remember { mutableStateOf("")}
    var passwordVisible by remember { mutableStateOf(false) }
    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() && erorMessage.isEmpty() }
    val focusManager = LocalFocusManager.current

    fun validate(){
        if (password != passwordValidate){
            erorMessage = "Password tidak sama"
        }else {
            erorMessage = ""
        }
    }



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
                    value = nama,
                    onValueChange = { nama = it },
                    placeholder = { Text("Nama", color = Color.Gray) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors
                        (
                        backgroundColor =  Color.White,
                        textColor = Color.Black,
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
                        textColor = Color.Black,
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
                        textColor = Color.Black,
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

            Card(elevation = 5.dp) {
                TextField(
                    value = passwordValidate,
                    onValueChange = { passwordValidate = it },
                    placeholder = { Text("Konfirmasi Password", color = Color.Gray) },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier .fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.textFieldColors
                        (
                        backgroundColor = Color.White,
                        textColor = Color.Black,
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
            // Cek Password Match
            validate()
            if (erorMessage.isNotEmpty()){
                Text(text = erorMessage,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left)
            }

            Button( onClick = {onclickRegister(nama, email, password)},
                enabled = isValidate,
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
    ErrorImageAuth(isImageValidate = imageError)
    ProgressBarLoading(isLoading = loadingProgressBar)
}

// Kode Program Untuk Page Verifikasi Email
@Composable
fun TopVerifikasi(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 35.dp, bottom = 10.dp)) {
        Text(text = "Verifikasi",
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 28.sp)
    }
}

@Composable
fun verifyPage(navController: NavHostController) {
    Box{
        BackgroundImage()
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)

        ) {
            TopVerifikasi()
            Text(text = "Kami telah mengirimkan email ke untuk Verifikasi Silhakan Cek Email Anda Untuk Verifikasi",
                modifier = Modifier. padding(25.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
            Button(
                onClick = { navController.navigate(RouteNav.Login.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 10.dp)
            ) {
                Text(text = "Login", fontWeight = FontWeight.Bold, color = Color.White)
            }
            Spacer(modifier = Modifier.padding(top = 30.dp))
            Logo()
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun testpage() {
//    val viewModel = LoginViewModel()
//    val loadingProgressBar = viewModel.progressBar.value
//    val imageError = viewModel.imageErrorAuth.value
//    val navController = rememberNavController()
//    Registerform(navController = navController, loadingProgressBar = loadingProgressBar, onclickRegister = viewModel::register)
//}






