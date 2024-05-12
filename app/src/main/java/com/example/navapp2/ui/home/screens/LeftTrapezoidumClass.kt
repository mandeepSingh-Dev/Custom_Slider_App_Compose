package com.example.navapp2.ui.home.screens

import android.graphics.Matrix
import android.util.Log
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.layer.GraphicsLayer
import androidx.compose.ui.graphics.layer.drawLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.RoundedPolygon
import com.example.navapp2.Graph.nestedGraphs.NavGraphHome
import com.example.navapp2.R
import kotlinx.coroutines.delay

@Composable
fun LeftTrapezoidum(modifier: Modifier) {




    var valueX2 by remember { mutableStateOf(0f) }
    var valueY2 by remember { mutableStateOf(-0f) }

    var valueX3 by remember { mutableStateOf(0f) }
    var valueY3 by remember { mutableStateOf(600f) }

    val shapePathAnimDuration = 1500

    var valuex2Anim = animateFloatAsState(targetValue = valueX2, animationSpec = tween(durationMillis = shapePathAnimDuration))
    var valuex3Anim = animateFloatAsState(targetValue = valueX3, animationSpec = tween(durationMillis = shapePathAnimDuration))

    var valueY2Anim = animateFloatAsState(targetValue = valueY2, animationSpec = tween(durationMillis = shapePathAnimDuration))
    var valueY3Anim = animateFloatAsState(targetValue = valueY3, animationSpec = tween(durationMillis = shapePathAnimDuration))


    LaunchedEffect(key1 = true, block = {
        delay(200)
        valueX2 = 500f
        valueY2 = 600 * 0.85f

        valueX3 = 500f
        valueY3 = 600 * 0.25f
    })

    var scale by remember {
        mutableStateOf(0.2f)
    }

    var translationnX by remember {
        mutableStateOf(0f)
    }

    LaunchedEffect(key1 = true, block = {
        delay(1000)
        scale = 1f

        translationnX = 0f
    })

    var scaleAnim = animateFloatAsState(targetValue = scale, animationSpec = tween(durationMillis = 2000))
    var sizeAnim = animateFloatAsState(targetValue = translationnX, animationSpec = tween(durationMillis = 2000))

    val imageResources = ImageBitmap.imageResource(id = R.drawable.unsplash)


    Card(modifier = modifier.clip(MyShape())) {

        Image(painter = painterResource(id = R.drawable.unsplash), contentDescription = "",
            modifier = modifier.clipToBounds()
            /*      .clip(MyShape())
                  .border(1.dp, Color.Black, RoundedCornerShape(20.dp))*/)
    }



   /* Box(
        modifier = modifier.drawWithContent {
            val path = Path().apply {
                //For left card
                lineTo(0f, 600f)
                lineTo(valuex2Anim.value, 600 * 0.85f*//*valueY2Anim.value*//*)
                lineTo(valuex3Anim.value, 600 * 0.25f*//*valueY3Anim.value*//*)
                close()
            }

            val paint = Paint().apply {
                this.strokeWidth = 10f
                this.strokeCap = StrokeCap.Round
                this.color = Color.Red
                this.pathEffect = PathEffect.cornerPathEffect(30f)
            }

            drawPath(
                path = path,
                color = Color.Red,
                style = Stroke(width = 10f, pathEffect = PathEffect.cornerPathEffect(30f))
            )
            drawWithLayer {
                Text(text = "fvknfkvnfjknfvknfkvnfjknfvknfkvnfjknfvknfkvnfjknfvknfkvnfjknfvknfkvnfjknfvknfkvnfjknfvknfkvnfjkn")
//                drawImage(image = imageResources, style = Stroke(width = 10f,  cap = StrokeCap.Round, pathEffect = PathEffect.cornerPathEffect(30f)), blendMode = BlendMode.SrcOver)
            }
        },
    )
    {
    }*/




}
@Composable
fun RightTrapezoidum(modifier : Modifier) {


    var valueX2 by remember { mutableStateOf(500f) }
    var valueY2 by remember { mutableStateOf(-200f) }

    var valueX3 by remember { mutableStateOf(500f) }
    var valueY3 by remember { mutableStateOf(800f) }

    val shapePathAnimDuration = 1500

    var valuex2Anim = animateFloatAsState(targetValue = valueX2, animationSpec = tween(durationMillis = shapePathAnimDuration))
    var valuex3Anim = animateFloatAsState(targetValue = valueX3, animationSpec = tween(durationMillis = shapePathAnimDuration))

    var valueY2Anim = animateFloatAsState(targetValue = valueY2, animationSpec = tween(durationMillis = shapePathAnimDuration))
    var valueY3Anim = animateFloatAsState(targetValue = valueY3, animationSpec = tween(durationMillis = shapePathAnimDuration))


    LaunchedEffect(key1 = true, block = {
        delay(200)
        valueX2 = 0f
        valueY2 = 600 * 0.85f

        valueX3 = 0f
        valueY3 = 600 * 0.25f
    })



    Box(modifier = modifier .drawWithCache {

        Log.d("dkvdkvmkdfvfd",size.width.toString() + "RightTrapezoidum")

        val path = Path().apply {
            //For left card
//            lineTo(0f, 600f)
//            lineTo(500f, 600*0.85f,)
//            lineTo(500f, 600 * 0.25f)

            moveTo(500f,0f)

            lineTo(500f, 600f)
            lineTo(valuex2Anim.value, 500f)
            lineTo(valuex3Anim.value, 150f)

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

@Composable
fun LeftRightTrapezodiumsScreen(onNavigate: (String) -> Unit){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(colors = listOf(Color.Black, Color.Cyan)))
            .clickable {
                onNavigate(NavGraphHome.MoveImageScreen.route)
            }) {
        imageShape(Modifier.weight(1f))
        RightTrapezoidum(Modifier.weight(1f))
    }
}

@Composable
fun TrapezoidalShape(modifier : Modifier) {

    Box(modifier = modifier) {
        androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                lineTo(0f, 600f)
                lineTo(500f, 600 * 0.85f)
                lineTo(500f, 600 * 0.25f)
                close()
            }

            // Clip the canvas to the trapezoidal shape
            clipPath(path) {
                // Draw the trapezoidal shape
                drawPath(path, Color.Blue)
            }
        }
        Row(modifier = Modifier
            .clipToBounds()
            .drawWithContent {
                drawWithLayer {

                }
            }
            )
        {
            // Add items to the Row layout
            Image(painter = painterResource(id = R.drawable.unsplash), contentDescription = "", contentScale = ContentScale.Crop)
        }
    }


}


class MyShape() : Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val path = Path().apply {
            lineTo(0f, 600f)
            arcTo(Rect(0f,600f,0f,0f),-90f,90f, false)
           // cubicTo(0f,0f, 0f,10f,0f, 20f)
            lineTo(500f, 600 * 0.85f)
            arcTo(Rect(0f,600f,0f,0f),-90f,90f, false)
            lineTo(500f, 600 * 0.25f)
            arcTo(Rect(0f,600f,0f,0f),-90f,90f, false)

//            quadraticBezierTo(0f,-40f,0f,-40f)


         /*   lineTo(0f, size.height)
            lineTo(size.width,size.height*0.85f)
            lineTo(size.width,size.height*0.25f)*/

//            this.addRoundRect(RoundRect(0f,0f,size.width,size.height),Path.Direction.Clockwise)
            close()
        }
        val pathSize = path.getBounds().size

        val matrix = Matrix()

        matrix.postScale(
            size.width / pathSize.width,
            size.height / pathSize.height)

        path.asAndroidPath().transform(matrix)





        return Outline.Generic(path = path)
    }
}



fun ContentDrawScope.drawWithLayer(block: ContentDrawScope.() -> Unit) {
    with(drawContext.canvas.nativeCanvas) {
        val checkPoint = saveLayer(null, null)
        block()
        restoreToCount(checkPoint)
    }
}


fun Modifier.drawWithLayer(block: ContentDrawScope.() -> Unit) = this.then(
    Modifier.drawWithContent {
        drawWithLayer {
            block()
        }
    }
)

@Composable
fun com(modifier : Modifier){
    Box(modifier = modifier.drawWithContent {

        val path = Path().apply {
            lineTo(0f, 600f)
            // cubicTo(0f,0f, 0f,10f,0f, 20f)
            lineTo(500f, 600 * 0.85f)
            lineTo(500f, 600 * 0.25f)
            close()
        }

        val paint = Paint().apply {
            color = Color.Blue
            pathEffect = PathEffect.cornerPathEffect(30f)
        }

        drawPath(path = path, color = Color.Blue)
        drawWithLayer {
            drawContent()
        }

    }){
        Image(painter = painterResource(id = R.drawable.unsplash), contentDescription = "",modifier =Modifier.clipToBounds())
    }
}

@Composable
fun imageShape(modifier: Modifier){
    Box(modifier = modifier.clip(shape = RoundedCornerShape(20f))
        .padding(20.dp)
            .wrapContentSize()
            .graphicsLayer {
                this.shape = MyShape()
                clip = true
            }
            .background(color = Color.Red)
            .drawBehind {

            }){
        Image(painter = painterResource(id = R.drawable.unsplash), contentDescription = "")
    }

}