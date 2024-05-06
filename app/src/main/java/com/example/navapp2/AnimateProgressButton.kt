package com.example.navapp2

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AnimateProgressButton() {

    var interactionSource = remember {
        MutableInteractionSource()
    }

    val isPressed = interactionSource.collectIsPressedAsState()

    val cornersAnim = animateFloatAsState(targetValue = if(isPressed.value) 60f else 20f, animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy))
    val scaleAnim = animateFloatAsState(targetValue = if(isPressed.value) 0.4f else 1f, animationSpec = tween(durationMillis = 100))


    val buttonFullWidth = remember {
        mutableStateOf(100)
    }

    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(brush = Brush.sweepGradient(colors = listOf(Color.Magenta, Color.Blue)))
            .onPlaced {
                Log.d("dvdkvmfk", it.size.width.toString())
                buttonFullWidth.value = it.size.width
            }) {
        Button(onClick = {},
            shape = RoundedCornerShape(Math.abs(cornersAnim.value)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            interactionSource = interactionSource,
           modifier = Modifier
               .scale(scaleAnim.value)
        ) {
            Text(text = "Hello bro", color = Color.Black)
        }
    }

}

@Preview
@Composable
fun previewAnimateProgressButton(){
    AnimateProgressButton()
}

@Composable
fun movingAnimateButton(){

    var offset = remember {
        mutableStateOf(Offset(0f,0f))
    }

    var offsetAnim = animateOffsetAsState(targetValue = offset.value, animationSpec = tween(durationMillis = 2000))

    LaunchedEffect(key1 = true, block = {
        delay(500)
        offset.value = Offset(x = 50f, y = 50f)
        delay(500)
        offset.value = Offset(x = 100f, y = 100f)
        delay(500)
        offset.value = Offset(x = 150f, y = 150f)
        delay(500)
        offset.value = Offset(x = 100f, y = 100f)
        delay(500)
        offset.value = Offset(x = 150f, y = 150f)
    })

    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(brush = Brush.sweepGradient(colors = listOf(Color.Magenta, Color.Blue)))
            ) {
        Button(onClick = {},
            shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            modifier = Modifier
                .offset(offsetAnim.value.x.dp,offsetAnim.value.y.dp)
        ) {
            Text(text = "Hello bro", color = Color.Black)
        }
    }

}