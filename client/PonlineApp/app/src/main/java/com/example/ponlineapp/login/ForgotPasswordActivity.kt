package com.example.ponlineapp.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.R
import com.example.ponlineapp.navigation.RouteNav


@Composable
fun TopBarForgotPassword(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 35.dp, bottom = 10.dp)) {
        Text(text = stringResource(id = R.string.Lupa_Password),
//             style = MaterialTheme.typography.bodyLarge
            fontSize = 28. sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 15.dp)
        )
    }
}


@Composable
fun Logo(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {

        Icon(
            painter = painterResource(R.drawable.logo_ponline),
            contentDescription = stringResource(id = R.string.logo),
            tint = colorResource(id = R.color.blue_100),
            modifier = Modifier
                .size(180.dp)
                .padding(top = 30.dp),

            )
    }
}

@Composable
fun ForgotPassword(navController: NavHostController)
{
    var emailforgot by remember { mutableStateOf("") }
    val onUserNameChange = { text : String ->
        emailforgot = text
    }
    Box{
        BackgroundImage()
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp))
        {
            TopBarForgotPassword()
            Text(text = "Kami akan mengirimkan link ke alamat email anda untuk mengatur ulang Password.")

            TextField(
                    value = emailforgot,
                    onValueChange = { onUserNameChange(it) },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(elevation = 15.dp),
                    shape = RoundedCornerShape(15.dp),
                    placeholder = { Text("Masukkan Email") },
                    colors = TextFieldDefaults.textFieldColors
                        (
                        backgroundColor = Color.White,
                        textColor = Color.Gray,
                        //untuk menghilangkan underline
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent

                    ),
                    singleLine = true

                )

            Button( onClick = { navController.navigate(RouteNav.ConfirmPassword.route + "/$emailforgot")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
            ) {
                Text(text = "Kirim Link", fontWeight = FontWeight.Bold, color = Color.White)
            }
            Logo()

        }
    }
}


//@Composable
//fun CustomTextField(
//    title: String,
//    textState: String,
//    onTextChange: (String) -> Unit,
//) {
//
//        TextField(
//            value = textState,
//            onValueChange = { onTextChange(it) },
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(15.dp),
//            colors = TextFieldDefaults.textFieldColors
//                (
//                textColor = Color.Gray,
//                //untuk menghilangkan underline
//                disabledTextColor = Color.Transparent,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//                disabledIndicatorColor = Color.Transparent
//
//            ),
//            singleLine = true
//
//        )
//
//}


@Composable
fun ConfirmPassword(navController: NavHostController, email: String?)
{
    Box {
        BackgroundImage()
        Column(modifier = Modifier.padding(top = 15.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
            Text(text = "Cek Email",
//             style = MaterialTheme.typography.bodyLarge
                fontSize = 28. sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 15.dp))
            Text(text = "Link  pengaturan ulang password telah dikirimkan ke email $email, " +
                    "silahkan cek email anda untuk melakukan pengautran ulang Password.",
                modifier = Modifier.padding(start = 15.dp)
                )
            Button( onClick = { navController.navigate(RouteNav.Login.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 15.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
            ) {
                Text(text = "Masuk", fontWeight = FontWeight.Bold, color = Color.White)
            }
            Column(modifier = Modifier.padding(top = 200.dp)) {
                Logo()
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Testingapp(){
    val navController = rememberNavController()
    ForgotPassword(navController = navController)
}


@Composable
fun CreateNewPassword()
{
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Box{
        BackgroundImage()
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 30.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Buat Password Baru",
//             style = MaterialTheme.typography.bodyLarge
                fontSize = 28. sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold)

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

            Card(elevation = 5.dp) {
                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = { Text("Konfirmasi Password", color = Color.Gray) },
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
            Column(modifier = Modifier.padding(top = 10.dp)) {
                Button( onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                    shape = RoundedCornerShape(20.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 10.dp)
                ) {
                    Text(text = "Buat Password Baru", fontWeight = FontWeight.Bold, color = Color.White)
                }
            }

            Column(modifier = Modifier.padding(top = 150.dp)) {
                Logo()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun testingCreate() {
    CreateNewPassword()
}

