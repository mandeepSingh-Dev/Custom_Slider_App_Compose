package com.example.navapp2.ui.common.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.navapp2.Graph.nestedGraphs.NavGraphHome

@Composable
fun ZeroWidthToFullWidthAnimation(onNavigate : (route : String) -> Unit) {

    var isFullWidth = remember {
        mutableStateOf(false)
    }
    var modifier = remember {
        mutableStateOf(Modifier)
    }.value
    if(isFullWidth.value){
        modifier.fillMaxWidth()
    }else{
        modifier.wrapContentWidth()
    }

    Box(modifier = Modifier
        .padding(20.dp)
        .background(
            brush = Brush.linearGradient(listOf(Color.Yellow, Color.Gray)),
            shape = RoundedCornerShape(30.dp)
        )
        .padding(10.dp)
        .clickable {
            isFullWidth.value = !isFullWidth.value

            onNavigate(NavGraphHome.GraphRoute)
            Log.d("Fvfmkvfnv", "Hello")
        }) {
        Text(text = "Click Me")
    }

}

fun Modifier.setCustomSize(isFullWidth : Boolean): Modifier {
    Log.d("flfmjkbfv",isFullWidth.toString())

    if(isFullWidth)this.fillMaxWidth()else this.wrapContentWidth()
    return this
}