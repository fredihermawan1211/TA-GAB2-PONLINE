package com.example.ponlineapp.profil

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.ponlineapp.R
import com.example.ponlineapp.login.BackgroundImage
import com.example.ponlineapp.navigation.RouteNav
import com.example.ponlineapp.ui.theme.PonlineAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(navController: NavHostController) {
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
                EditProfileAppBar(
                    navController = navController,
                    topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
                    ))
            }

            EditProfileImage()
            Spacer(modifier = Modifier.padding(vertical = 20.dp))

            Column(modifier = Modifier.padding(8.dp,4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    singleLine = true,
                    label = { Text("Nama") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                    )
                )
            }
            Column(modifier = Modifier.padding(8.dp,4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    singleLine = true,
                    label = { Text("Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
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
                        focusedLabelColor = Color.Black,
                        disabledLabelColor = Color.Black,
                        disabledBorderColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                    )
                )
            }
            Column(modifier = Modifier.padding(15.dp,12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,) {
                Button( onClick = { Toast.makeText(ctx, "Data Tersimpan", Toast.LENGTH_SHORT).show()
                },
                    enabled = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .height(IntrinsicSize.Min),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100)),
                    shape = RoundedCornerShape(30.dp),
                    elevation = ButtonDefaults.elevation(defaultElevation = 8.dp),

                ) {
                    androidx.compose.material3.Text(
                        text = "Simpan",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun EditProfileImage() {
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
                        .clickable { launcher.launch("image/*") }
                        .fillMaxSize()
                        .clip(CircleShape)
                    ,
                    contentScale = ContentScale.Crop
                )
                FloatingActionButton(
                    modifier = Modifier
                        .align(Alignment.BottomEnd),
                    // on below line we are adding on click for our fab
                    onClick = {launcher.launch("image/*")
                    },
                    backgroundColor = blue,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                ) {
                    // on below line we are
                    // adding icon for button.
                    Icon(imageVector = Icons.Filled.Edit, contentDescription = "Add")
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileAppBar(navController: NavHostController,
    topAppBarColors: TopAppBarColors,
    modifier: Modifier = Modifier
){
    androidx.compose.material3.TopAppBar(
        title = { 
                Text(text = "Cancle")
        },
        navigationIcon = {
            Box {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    IconButton(onClick = { navController.navigate(RouteNav.Profile.route) }) {
                        Image(Icons.Filled.Cancel, null)
                    }
                }
            }
        },
        colors = topAppBarColors,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DefaultEditUserPreview() {
    PonlineAppTheme() {
//        EditProfileScreen(navController = NavHostController)
    }
}