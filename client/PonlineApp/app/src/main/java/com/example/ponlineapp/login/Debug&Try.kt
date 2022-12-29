import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ponlineapp.R
import com.example.ponlineapp.login.BackgroundImage
import com.example.ponlineapp.login.TopBarLogin
import com.example.ponlineapp.login.components.ErrorImageAuth
import com.example.ponlineapp.login.components.ProgressBarLoading
import com.example.ponlineapp.navigation.RouteNav

//@Composable
//fun testingsupport() {
//
//    //form
//    //deklarasi Variabel
//    var email by remember { mutableStateOf(value = "") }
//    var password by remember { mutableStateOf(value = "") }
////    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() }
//    val isErroremail by remember {
//        derivedStateOf {
//            if (email.isEmpty()){
//                false
//            } else {
//                Patterns.EMAIL_ADDRESS.matcher(email).matches().not()
//            }
//        } }
//    val focusManager = LocalFocusManager.current
//    // Creating a variable to store toggle state
//    var passwordVisible by remember { mutableStateOf(false) }
//
//    Box {
//        BackgroundImage()
//
//        Column(
//            horizontalAlignment = Alignment.Start,
//            modifier = Modifier
//                .padding(start = 15.dp, end = 15.dp)
//                .fillMaxSize()
//        )
//        {
//            Column(modifier = Modifier.fillMaxWidth())
//            {
//
//                //form untuk login
//                Text(
//                    text = "E-Mail",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 16.sp,
//                    modifier = Modifier.padding(top = 10.dp)
//                )
//                Column()
//                {
//                    OutlinedTextField(
//                        value = email,
//                        onValueChange = { email = it },
//                        placeholder = { Text(text = "Masukkan Email") },
//                        supportingtext = {
//                            if (isErroremail) {
//                                Text(text = "Masukkan Email dengan benar")
//                            }
//                        },
//                        isError = isErroremail,
//                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
//                        modifier = Modifier.fillMaxWidth(),
//                        shape = RoundedCornerShape(15.dp),
//                        colors = TextFieldDefaults.textFieldColors
//                            (
//                            backgroundColor = Color.White,
//                            textColor = Color.Gray,
//                            //untuk menghilangkan underline
//                            disabledTextColor = Color.Transparent,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent,
//                            disabledIndicatorColor = Color.Transparent
//
//                        ),
//                        singleLine = true,
//                    )
//                }
//            }
//        }
//    }
//}


@Preview(showBackground = true)
@Composable
fun test2() {
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier .fillMaxSize()) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                isError = false
            },
            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Info, "Error", tint = Color.White)
            },
            singleLine = true,
            isError = isError,
//            keyboardActions = KeyboardActions { validate(text) },
        )
        if (isError) {
            Text(
                text = "Error message",
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}