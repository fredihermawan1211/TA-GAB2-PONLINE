package com.example.ponlineapp.profil

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
//import androidx.compose.material3.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.ponlineapp.R
import com.example.ponlineapp.login.BackgroundImage
import com.example.ponlineapp.navigation.RouteNav
import com.example.ponlineapp.ui.theme.PonlineAppTheme

//class ProfileActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PonlineAppTheme() {
//                // A surface container using the 'background' color from the theme
//                androidx.compose.material.Surface(color = MaterialTheme.colors.background) {
//                    ProfileScreen()
//                }
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileAppBar(navController : NavHostController,
    topAppBarColors: TopAppBarColors,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { },
        navigationIcon =  {
            Box {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    IconButton(onClick = { navController.navigate(RouteNav.Home.route) }) {
                        Image(Icons.Filled.ArrowBack, null)
                    }
                }
            }
        }
        ,
        colors = topAppBarColors,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    var name by rememberSaveable { mutableStateOf("Nama User") }
    var email by rememberSaveable { mutableStateOf("Email User") }
    var jabatan by rememberSaveable { mutableStateOf("Jabatan User") }
    val ctx = LocalContext.current
    Box {
        BackgroundImage()
        Column(
            modifier = Modifier
//                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProfileAppBar(
                    navController = navController,
                    topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                ),
                    modifier = Modifier.fillMaxWidth())
            }

            ProfileImage()
            Spacer(modifier = Modifier.padding(vertical = 20.dp))

            Column(modifier = Modifier.padding(8.dp,4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false,
                    readOnly = true,
                    singleLine = true,
                    label = { Text("Nama") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        disabledBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        disabledLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        disabledTextColor = Color.Black
                    )
                )
            }
            Column(modifier = Modifier.padding(8.dp,4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false,
                    readOnly = true,
                    singleLine = true,
                    label = { Text("Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        disabledBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        disabledLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        disabledTextColor = Color.Black
                    )
                )
            }
            Column(modifier = Modifier.padding(8.dp,4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,){
                    OutlinedTextField(
                        value = jabatan,
                        onValueChange = { jabatan = it },
                        modifier = Modifier.fillMaxWidth(),
                        enabled = false,
                        readOnly = true,
                        singleLine = true,
                        label = { Text("Jabatan") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            disabledBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black,
                            disabledLabelColor = Color.Black,
                            unfocusedLabelColor = Color.Black,
                            disabledTextColor = Color.Black
                        )
                    )
            }
            Column(modifier = Modifier.padding(8.dp,12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                Button( onClick = { Toast.makeText(ctx, "Ubah Password", Toast.LENGTH_SHORT).show()
                },
                    enabled = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .height(IntrinsicSize.Min),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                    shape = RoundedCornerShape(30.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
                ) {
                    androidx.compose.material3.Text(
                        text = "Ubah Password",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                
                Button( onClick = { navController.navigate(RouteNav.EditProfile.route)
                },
                    enabled = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .height(IntrinsicSize.Min),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                    shape = RoundedCornerShape(30.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
                ) {
                    androidx.compose.material3.Text(
                        text = "Ubah Profile",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                androidx.compose.material3.Text(
                    text = stringResource(R.string.app_version),
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )

            }

        }
        Button( onClick = { Toast.makeText(ctx, "Logour", Toast.LENGTH_SHORT).show()
        },
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 30.dp)
                .height(IntrinsicSize.Min)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.red_66)),
            shape = RoundedCornerShape(30.dp),
            elevation = ButtonDefaults.elevation(defaultElevation = 8.dp)
        ) {
            androidx.compose.material3.Text(
                text = "Logout",
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun ProfileImage() {
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.background
        else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri.value = it.toString() }
    }
    val ctx = LocalContext.current
    val blue = Color(0XFF3AB4F2)
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        androidx.compose.material.Card(
            backgroundColor = Color.Transparent,
//            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(160.dp),
            elevation = 0.dp
        ) {
            Box(
                modifier = Modifier
                    .border(BorderStroke(0.dp, Color.Transparent))
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.userprofile),
                    contentDescription = "profile",
                    modifier = Modifier
                        .wrapContentSize()
//                        .clickable { launcher.launch("image/*") }
                        .fillMaxSize()
                        .clip(CircleShape)
                    ,
                    contentScale = ContentScale.Crop
                )
//                FloatingActionButton(
//                    modifier = Modifier.align(Alignment.BottomEnd).clickable { launcher.launch("image/*") },
//                    // on below line we are adding on click for our fab
////                    onClick = {
////                        Toast.makeText(ctx, "Simple Floating Action Button", Toast.LENGTH_SHORT).show()
////                    },
//                    backgroundColor = blue,
//                    contentColor = Color.White,
//                    elevation = FloatingActionButtonDefaults.elevation(0.dp)
//                ) {
//                    // on below line we are
//                    // adding icon for button.
//                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Add")
//                }
            }
        }
    }
}
//
//@ExperimentalMaterial3Api
//@Preview()
//@Composable
//fun profile(){
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "Profile") },
//                navigationIcon = {
//                    IconButton(onClick = { /* handle back navigation */ }) {
//                        Icon(Icons.Filled.ArrowBack,"")
//                    }
//                }
//            )
//        },
//        content = {padding ->
//            Column(
//                modifier = Modifier
//                    .padding(padding)
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally ){
//                ProfileImage(R.drawable.ic_account,"account",)
//                Spacer(modifier = Modifier.height(16.dp))
//            }
//        }
//    )
//}

@Preview(showBackground = true)
@Composable
fun DefaultUserPreview() {
    PonlineAppTheme() {
//        ProfileScreen()
    }
}