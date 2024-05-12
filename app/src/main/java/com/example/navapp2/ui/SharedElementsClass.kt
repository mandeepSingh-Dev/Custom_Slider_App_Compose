package com.example.navapp2.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.navapp2.R


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedElement2(){



    var statee : Boolean by remember {
        mutableStateOf(false)
    }

    SharedTransitionLayout {
        AnimatedContent(targetState = statee, label = "") {targetState ->
            if(!targetState){
                Card(
                    backgroundColor = Color.Red,
                    border = BorderStroke(width = 1.dp, color = Color.Green),
                    elevation = 20.dp,
                    modifier = Modifier
                        .sharedElement(
                            state = rememberSharedContentState(key = "Card"),
                            animatedVisibilityScope = this
                        )
                        .fillMaxWidth()
                        .padding(20.dp).clickable {
                            statee = !statee
                        }
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.unsplash),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape))
                        Text(text = "Hello bro")
                    }
                }
            }else{
                Card(
                    backgroundColor = Color.Red,
                    border = BorderStroke(width = 1.dp, color = Color.Blue),
                    elevation = 20.dp,
                    modifier = Modifier
                        .sharedElement(
                            state = rememberSharedContentState(key = "Card"),
                            animatedVisibilityScope = this
                        )
                        .fillMaxWidth()
                        .padding(20.dp).clickable {
                            statee = !statee
                        }
                ) {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.unsplash),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(500.dp)
                                .clip(CircleShape))
                        Text(text = "Hello bro  brobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobrobro")
                    }
                }
            }
        }

    }

}

