package com.example.ponlineapp.login.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ponlineapp.R


@Composable
fun CustomRadioGroup(modifier: Modifier) {
    val options = listOf(
        "Pegawai",
        "Pemilik",
    )
    var selectedOption by remember {
        mutableStateOf("")
    }
    val onSelectionChange = { text: String ->
        selectedOption = text
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        options.forEach { text ->
            Button(
                onClick = { onSelectionChange(text) },
                modifier = Modifier.bounceClick(),
                colors =
                if (text == selectedOption)
                    ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.blue_100))
                else
                    ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ,

                elevation = ButtonDefaults.elevation(),



                ) {
                Text(text = text, fontWeight = FontWeight.Bold, color = if (text == selectedOption) Color.White else colorResource(
                    R.color.blue_100) )
            }
        }
    }
}
//            Row(
//                modifier = Modifier
//                    .padding(
//                        all = 8.dp,
//                        ),
//                ) {
//                    Text(
//                        text = text,
//                        style = MaterialTheme.typography.body1.merge(),
//                        color = Color.White,
//                        modifier = Modifier
//                            .clip(
//                                shape = RoundedCornerShape(
//                                    size = 12.dp,
//                                ),
//                            )
//                            .clickable {
//                                onSelectionChange(text)
//                            }
//                            .background(
//                                if (text == selectedOption) {
//                                    Color.Magenta
//                                } else {
//                                    Color.LightGray
//                                }
//                            )
//                            .padding(
//                                vertical = 12.dp,
//                                horizontal = 16.dp,
//                            ),
//                    )
//            }
//        }
//    }

enum class ButtonState { Pressed, Idle }
fun Modifier.bounceClick() = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val scale by animateFloatAsState(if (buttonState == ButtonState.Pressed) 0.90f else 1f)

    this
        .graphicsLayer() {
            scaleX = scale
            scaleY = scale
        }
        .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = {  }
        )
        .pointerInput(buttonState) {
            awaitPointerEventScope {
                buttonState = if (buttonState == ButtonState.Pressed) {
                    waitForUpOrCancellation()
                    ButtonState.Idle
                } else {
                    awaitFirstDown(false)
                    ButtonState.Pressed
                }
            }
        }
}