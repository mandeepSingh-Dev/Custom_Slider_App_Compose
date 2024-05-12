package com.example.navapp2.ui.home.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.navapp2.Graph.nestedGraphs.NavGraphHome
import com.example.navapp2.Graph.screensEnum.HomeScreens
import com.example.navapp2.utils.toDp
import com.example.navapp2.utils.toPx
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Composable
fun moveImage(onNavigate : (String) -> Unit){
    val context = LocalContext.current
    val screenWidth = LocalContext.current.resources.displayMetrics.widthPixels

Log.d("fvjfnvfkjvnf",screenWidth.toString())
    var width = 0
    var buttonWidth = 0

    var nWidth = 0

    var stateX : Float by remember { mutableStateOf(0f) }
    var offsetX : Float by remember { mutableStateOf(0f) }

        // var stateX : Float by remember { mutableStateOf(0f) }
    var interactionSource = remember{ MutableInteractionSource() }

    var buttonNewWidth : Float by remember {
        mutableStateOf(100f)
    }

    LaunchedEffect(key1 = true, block = {
        interactionSource.interactions.collect {
            Log.d("vfkvmfkvnfv",it.toString())
        }
    })

    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.linearGradient(colors = listOf(Color.Blue,Color.Black)))
        .clickable { onNavigate(NavGraphHome.SharedComponentScreen.route) }) {
        Row(modifier = Modifier
            .padding(start = 30.dp, end = 30.dp)
            .fillMaxWidth()
            .wrapContentHeight().align(Alignment.Center)
            .onSizeChanged {
                width = it.width
                buttonNewWidth = (width / 2).toFloat()
                Log.d("flvnfjvnf", buttonNewWidth.toString())
                //  Log.d("flvnfjvnf",(buttonNewWidth/2).toString())
            }

            .background(Color.Yellow))
        {

            Button(
                onClick = {},
                modifier = Modifier
                    .width((buttonNewWidth.toDp(context)).dp)
                    .offset { IntOffset(x = offsetX.roundToInt(), y = 0) }
                    .onSizeChanged { buttonWidth = it.width }
                    .pointerInput(Unit,) {
                        detectDragGestures(onDragEnd = {
                            Log.d("fvlmkkfvmf", "dragEnd")
                            Log.d("fvlmkkfvmf", "dragCancel")
                            val centerPoint = nWidth / 2

                            val nCenterPoint = centerPoint / 2

                            Log.d("fknvkjfvnfkvnf", nCenterPoint.toString() + " new centerPoint")
                            Log.d("fknvkjfvnfkvnf", centerPoint.toString() + " centerPoint")
                            Log.d("fknvkjfvnfkvnf", offsetX.toString() + " offsetX")
                            Log.d("fknvkjfvnfkvnf", nWidth.toString() + " nWidth")

                            if (offsetX <= centerPoint) {
                                offsetX = 30f
                            } else {
                                offsetX = nWidth - 30f
                            }

                        }) { change, dragAmount ->
                            change.consume()





                            nWidth = width - (buttonWidth
                                .toFloat()
                                .toPx(context)).toInt()
                            val newX = (offsetX + dragAmount.x)

                            Log.d("fvlmfkvfmlk", width.toString() + " width")
                            Log.d("fvlmfkvfmlk", nWidth.toString() + " new Width")
                            Log.d("fvlmfkvfmlk", buttonWidth.toString() + " buttonoWIdth")
                            Log.d("fvlmfkvfmlk", newX.toString() + " newX")


                            if (newX >= 30 && newX < nWidth - 30) {
                                offsetX = newX
                                Log.d("fvlmfkvfmlk", newX.toString() + " newX")
                            }

                        }
                    },
                interactionSource = interactionSource,
            ){
                Text(text = "Hello")
            }
        }
    }


}