package com.example.ponlineapp.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ponlineapp.R
import com.example.ponlineapp.login.BackgroundImage

@Composable
fun TopBarRole(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 35.dp, bottom = 10.dp)) {
        Text(text = "Pilih Role",
//             style = MaterialTheme.typography.bodyLarge
            fontSize = 28. sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RoleScreen(){
    Box(modifier = Modifier){
        BackgroundImage()
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxSize()
        ) {
            TopBarRole()
            Text(text = "Tentukan jabatan anda dalam penggunaan aplikasi Ponline")
            CustomRadioGroup(modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

