package com.example.navapp2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.toPath
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navapp2.ui.theme.NavApp2Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var navController = rememberNavController()

            NavApp2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    
                    ScreenOne(onNavigate = {})
/*
                    NavHost(navController = navController, startDestination = "Screen1"){

                        composable(
                            route= "Screen1",
                            enterTransition = {
                                fadeIn(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideIntoContainer(
                                    animationSpec = tween(300, easing = EaseIn),
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                                )
                            },
                            exitTransition = {
                                fadeOut(
                                    animationSpec = tween<Float>(
                                        300, easing = LinearEasing
                                    )
                                ) + slideOutOfContainer(
                                    animationSpec = tween(300, easing = EaseOut),
                                    towards = AnimatedContentTransitionScope.SlideDirection.End
                                )
                            })
                        {
                            ScreenOne(onNavigate = {
                                navController.navigate(it)
                            })
                        }
                        composable(
                            route= "Screen1",
                            enterTransition = {
                                fadeIn(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideIntoContainer(
                                    animationSpec = tween(300, easing = EaseIn),
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                                )
                            },
                            exitTransition = {
                                fadeOut(
                                    animationSpec = tween<Float>(
                                        300, easing = LinearEasing
                                    )
                                ) + slideOutOfContainer(
                                    animationSpec = tween(300, easing = EaseOut),
                                    towards = AnimatedContentTransitionScope.SlideDirection.End
                                )
                            }){
                            ScreenTwo(onNavigate = {
                                navController.navigate(it)
                            })
                        }

                    }
*/
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScreenOne( onNavigate : (String) -> Unit) {
//    Text(text = "Helliddfjdfj", modifier = Modifier.clickable { onNavigate("Screen2") })


    Box(
        modifier = Modifier
            .padding(
                30.dp
            )
            .drawWithCache {


                val rect = Rect(Offset.Zero, size)

                val path = androidx.compose.ui.graphics
                    .Path()
                    .apply {
                        moveTo(0f, 0f)
                        //For left card
//                        lineTo(0f, 600f)
//                        lineTo( 500f, 600 * 0.85f,)
//                        lineTo( 500f, 600 * 0.25f)
//                        For right card

                        val  topLeftX = 100f;
                        val  topLeftY = 100f;
                        val  topRightX = 300f;
                        val  topRightY = 100f;
                        val  bottomRightX = 400f;
                        val  bottomRightY = 300f;
                        val  bottomLeftX = 50f;
                        val  bottomLeftY = 300f;

                        // Create a Path object

                        // Move to starting point
                        moveTo(topLeftX, topLeftY);

                        // Add lines to form the trapezoid
                        lineTo(topRightX, topRightY);
                        lineTo(bottomRightX, bottomRightY);
                        lineTo(bottomLeftX, bottomLeftY);

                      /*  lineTo( 500f, 450f,)
                        lineTo( 500f, 138f)*/
                        close()
                    }

                val paint = Paint().apply {
                    shader = LinearGradientShader(
                        rect.topLeft,
                        rect.bottomRight,
                        listOf(Color.Red, Color.Blue)
                    )
                    pathEffect = PathEffect.cornerPathEffect(60f)
                }

                onDrawBehind {

                    drawIntoCanvas { canvas ->
                        canvas.drawOutline(
                            outline = Outline.Generic(path),
                            paint = paint
                        )
                    }

                }


                /*   val path = Path()
                path.moveTo(0f, 0f)
                path.lineTo(0f, size.height/2)
                path.lineTo(size.width/2, size.height/7)
                path.moveTo(0f, 200f)
                path.close()
                onDrawBehind {
                    drawPath(path, Color.Magenta, style = Stroke(
                        width = 2.dp.toPx(),
                        pathEffect = PathEffect.cornerPathEffect(40.dp.toPx())
                    ))
                }*/


                /* val roundedPolygon = RoundedPolygon(
                    numVertices = 5,
                    radius = size.minDimension / 2,
                    centerX = size.width / 2,
                    centerY = size.height / 2,
                    rounding = CornerRounding(
                        size.minDimension / 10f,
                        smoothing = 0.1f
                    )
                )
                val roundedPolygonPath = roundedPolygon
                    .toPath()
                    .asComposePath()
                onDrawBehind {
                    drawPath(roundedPolygonPath, color = Color.Black)
                }*/
            }.graphicsLayer {
                rotationX = 90f
            }
    )
    
}
@Composable
fun ScreenTwo(  onNavigate : (String) -> Unit) {

    var t : Float by remember {
        mutableStateOf(0.0f)
    }
    var r = animateFloatAsState(targetValue = t).value

    rememberCoroutineScope().launch {
        delay(200)
        t = 1f
    }

    Text(text = "Hello Greetings Screen Two!", modifier = Modifier
        .clickable {
            t = 0f
            onNavigate("Screen1")
        }
        .background(Brush.linearGradient(listOf(Color.Red, Color.Blue))))
}

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Composable
fun moveImage(){
    val metrics = LocalContext.current.resources.displayMetrics
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

    Row(modifier = Modifier
        .padding(start = 30.dp, end = 30.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .onSizeChanged {
            width = it.width
            buttonNewWidth = (width / 2).toFloat()
            Log.d("flvnfjvnf", buttonNewWidth.toString())
            //  Log.d("flvnfjvnf",(buttonNewWidth/2).toString())
        }

        .background(Color.Yellow)) {
        
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

fun Float.toPx(context : Context): Float {
    val density = context.resources.displayMetrics.density
    return this*density
}
@Composable
fun Float.toDp(context: Context): Float {
    val density = context.resources.displayMetrics.density
    return (this)/density
}


sealed class Screen(val route: String) {
    object Feed: Screen("feed")
    object Adopt: Screen("adopt")
}