package com.example.navapp2.ui.home.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.navapp2.Graph.nestedGraphs.NavGraphHome
import com.example.navapp2.R
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun sharedComponent(onNavigate : (String) -> Unit){
    var showDetails by remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier.fillMaxSize().clickable { onNavigate(NavGraphHome.SharedElementApp_BoundsTransformExample.route) }) {
    }
    SharedTransitionLayout() {
        AnimatedContent(targetState = showDetails, label = "basic_transition") { targetState ->
            if (!targetState) {
                MainContent(
                    onShowDetails = {
                        showDetails = true
                    },
                    animatedVisibilityScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout
                )
            } else {
                DetailsContent(
                    onBack = {
                        showDetails = false
                    },
                    animatedVisibilityScope = this@AnimatedContent,
                    sharedTransitionScope = this@SharedTransitionLayout
                )
            }
        }
    }
}

@Composable
fun sharedElement2(){

}


