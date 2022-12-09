import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ponlineapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold 
            // Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Toggle Password", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        // Creating a variable to store password
                        var password by remember { mutableStateOf("") }

                        // Creating a variable to store toggle state
                        var passwordVisible by remember { mutableStateOf(false) }

                        // Create a Text Field for giving password input
                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Password") },
                            singleLine = true,
                            placeholder = { Text("Password") },
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
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
                }
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Test()
//{
//    var password by remember { mutableStateOf("") }
//    // Creating a variable to store toggle state
//    var passwordVisible by remember { mutableStateOf(false) }
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(top = 10.dp)) {
//        Card(elevation = 5.dp, modifier = Modifier.padding(horizontal = 10.dp))
//        {
//            Column() {
//                TextField(
//                    value = password,
//                    onValueChange = { password = it },
//                    placeholder = { androidx.compose.material3.Text("Masukkan Password", color = Color.Gray) },
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
//
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
//
//        }
//
//    }
//
//}

@Preview(showBackground = true)
@Composable
fun Test2(){
    Column(Modifier.fillMaxSize()) {
        Card(modifier = Modifier.padding(50.dp), elevation = 10.dp) {
            Testbed()
        }
    }
}

@Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    // TODO: b/149735981 semantics for content description
    val colorFilter = if (tint == Color.Unspecified) null else ColorFilter.tint(tint)
    val semantics = if (contentDescription != null) {
        Modifier.semantics {
            this.contentDescription = contentDescription
            this.role = Role.Image
        }
    } else {
        Modifier
    }
    Box(
        modifier
            .toolingGraphicsLayer()
            .defaultSizeFor(painter)
            .paint(
                painter,
                colorFilter = colorFilter,
                contentScale = ContentScale.Fit
            )
            .then(semantics)
    )
}

private fun Modifier.defaultSizeFor(painter: Painter) =
    this.then(
        if (painter.intrinsicSize == Size.Unspecified || painter.intrinsicSize.isInfinite()) {
            DefaultIconSizeModifier
        } else {
            Modifier
        }
    )

private fun Size.isInfinite() = width.isInfinite() && height.isInfinite()

// Default icon size, for icons with no intrinsic size information
private val DefaultIconSizeModifier = Modifier.size(24.dp)

@Composable
fun Testbed(tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)){
    Column() {
        Icon(painter = painterResource(R.drawable.logo_ponline),
            contentDescription = stringResource(id = R.string.logo),
            tint = tint)
        Image(painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.logo),
            contentScale = ContentScale.Inside,
            modifier = Modifier.padding(top = 2.dp).height(350.dp).width(350.dp))
    }

}



