package com.example.navapp2.ui.home.screens

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.navapp2.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope
) {
    Column() {
        with(sharedTransitionScope) {
            Image(
                painter = painterResource(id = R.drawable.unsplash),
                contentDescription = "Cupcake",
                modifier = Modifier.renderInSharedTransitionScopeOverlay(zIndexInOverlay = 1f)
                    .sharedElement(
                        rememberSharedContentState(key = "image"),
                        animatedVisibilityScope = animatedVisibilityScope,
                    )
                    .size(200.dp)
                    .clip(CircleShape).clickable { onBack() },
                contentScale = ContentScale.Crop
            )
        }
    }
}

