package com.example.navapp2

import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun LeftTrapezoidum(modifier: Modifier, rowWidth : Int) {




    var valueX2 by remember { mutableStateOf(50f) }
    var valueX3 by remember { mutableStateOf(50f) }

    var valueY2 by remember { mutableStateOf(0f) }
    var valueY3 by remember { mutableStateOf(0f) }

    var valuex2Anim = animateFloatAsState(targetValue = valueX2, animationSpec = tween(durationMillis = 500))
    var valuex3Anim = animateFloatAsState(targetValue = valueX3, animationSpec = tween(durationMillis = 500))

    var valueY2Anim = animateFloatAsState(targetValue = valueY2, animationSpec = tween(durationMillis = 500))
    var valueY3Anim = animateFloatAsState(targetValue = valueY3, animationSpec = tween(durationMillis = 500))


    LaunchedEffect(key1 = true, block = {
        delay(200)
        valueX2 = 500f
        valueX3 = 500f

        valueY2 = 600 * 0.85f
        valueY3 = 600 * 0.25f
    })

    var scale by remember {
        mutableStateOf(0.2f)
    }

    var translationnX by remember {
        mutableStateOf(-rowWidth.toFloat())
    }

    LaunchedEffect(key1 = true, block = {
        delay(1000)
        scale = 1f

        translationnX = 0f
    })

    var scaleAnim = animateFloatAsState(targetValue = scale, animationSpec = tween(durationMillis = 2000))
    var sizeAnim = animateFloatAsState(targetValue = translationnX, animationSpec = tween(durationMillis = 2000))

    Box(modifier = modifier
        .offset(x = sizeAnim.value.dp, 0.dp)
//        .scale(scaleAnim.value)
        .graphicsLayer {
        }
        .onSizeChanged {
            //  translationnX = -(it.width.toFloat())
        }
        .onPlaced {
            Log.d("flvmkfmvf", it.size.width.toString() + "onPlaced {")
        }
        .drawBehind {


            val path = Path().apply {
                //For left card
                lineTo(0f, 600f)
                lineTo(valuex2Anim.value, valueY2Anim.value,)
                lineTo(valuex3Anim.value, valueY3Anim.value)
//            moveTo(500f,0f)
//
//            lineTo(500f, 600f)
//            lineTo(0f, 500f)
//            lineTo(0f, 150f)

                close()
            }
            val paint = Paint().apply {
                this.strokeWidth = 10f
                this.strokeCap = StrokeCap.Round
                this.color = Color.Red
                this.pathEffect = PathEffect.cornerPathEffect(30f)
            }

            drawIntoCanvas {
                it.drawPath(path, paint)
            }
        }/*  .onPlaced {
            Log.d("dvlm3434vkmf",it.size.width.toString())
            translationnX = - (it.size.width.toFloat())
        }
*/


        /* .graphicsLayer {
             scaleX = scaleAnim.value
             scaleY = scaleAnim.value
         }*/) {

    }

}
@Composable
fun RightTrapezoidum(modifier: Modifier) {

    Box(modifier = modifier.drawWithCache {

        Log.d("dkvdkvmkdfvfd",size.width.toString() + "RightTrapezoidum")

        val path = Path().apply {
            //For left card
//            lineTo(0f, 600f)
//            lineTo(500f, 600*0.85f,)
//            lineTo(500f, 600 * 0.25f)

            moveTo(500f,0f)

            lineTo(500f, 600f)
            lineTo(0f, 500f)
            lineTo(0f, 150f)

            close()
        }
        val paint = Paint().apply {
            this.strokeWidth = 10f
            this.strokeCap = StrokeCap.Round
            this.color = Color.Red
            this.pathEffect = PathEffect.cornerPathEffect(30f)
        }

        onDrawBehind {
            drawIntoCanvas {
                it.drawPath(path, paint)
            }

        }


    }) {

    }

}


@Composable
fun paralleloGramShapeButton(){

    var valueX by remember {
        mutableStateOf(20f)
    }

    var valuexAnim = animateFloatAsState(targetValue = valueX, animationSpec = tween(durationMillis = 2000))



    Box(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .drawWithCache {

            val path = Path().apply {

                lineTo(valuexAnim.value, 0f)
                lineTo(750f, 0f)
                lineTo(650f, 300f)

                close()
            }

            val paint = Paint().apply {
                color = Color.Blue
                pathEffect = PathEffect.cornerPathEffect(30f)
            }

            onDrawBehind {
                drawIntoCanvas {
                    it.drawPath(path, paint)
                }
            }

        })

}