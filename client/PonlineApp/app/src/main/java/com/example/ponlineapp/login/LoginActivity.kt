package com.example.ponlineapp.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import com.example.ponlineapp.models.RouteNav

@Composable
fun BackgroundImage()
{
    Image(painter = painterResource(id = R.drawable.background), contentDescription = "homebg",
        modifier = Modifier .fillMaxSize(),
        contentScale = ContentScale.Crop)
}

@Composable
fun TopBarLogin(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 35.dp, bottom = 10.dp)) {
        Text(text = stringResource(id = R.string.Login),
//             style = MaterialTheme.typography.bodyLarge
             fontSize = 28. sp,
             fontFamily = FontFamily.SansSerif,
             fontWeight = FontWeight.Bold
            )
    }
}

@Composable
fun Loginform(navController: NavHostController) {
    //form
    Box{
        BackgroundImage()

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxSize())
        {
            //memanggil top bar login
            TopBarLogin()
            Column(modifier = Modifier .fillMaxWidth())
            {

                //form untuk login
                Text(text = "E-Mail", fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(top = 10.dp))
                Column()
                {
                    var value by remember { mutableStateOf("") }
                    TextField(
                        value = value,
                        onValueChange = { value = it },
                        placeholder = { Text("Masukkan Email") },
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
            }


            Column {
                Text(text = "Passsword" , fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(top = 10.dp))
                // Creating a variable to store password
                var password by remember { mutableStateOf("") }

                // Creating a variable to store toggle state
                var passwordVisible by remember { mutableStateOf(false) }
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Masukkan Password") },
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

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp))
            {
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Text(text = "Lupa Password??")
                    TextButton(onClick = { navController.navigate(RouteNav.ForgotPassword.route) }) {
                        Text(text = "Klk Disini", fontWeight = FontWeight.Bold, color = colorResource(R.color.blue_100))
                    }
                }

                Button( onClick = { navController.navigate(RouteNav.Dashboard.route)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                    shape = RoundedCornerShape(20.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
                ) {
                    Text(text = "Masuk", fontWeight = FontWeight.Bold, color = Color.White)
                }
                Button(onClick = {  }, modifier = Modifier .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(15.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
                ) {
                    Text(text = "Masuk Dengan Google")
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Belum Punya Akun??")
                    TextButton(onClick = { navController.navigate(RouteNav.Register.route) }) {
                        Text(text = "Buat Akun", fontWeight = FontWeight.Bold, color = colorResource(R.color.blue_100))
                    }
                }
                //panggil fungsi logo
                Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "Logo",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.height(300.dp)
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun Loginpage(){

    val navController = rememberNavController()

    Loginform(navController = navController)
}
