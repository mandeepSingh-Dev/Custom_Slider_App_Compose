/*
package com.example.navapp2.ui.home.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.clipPath
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.dp

@Composable
fun CustomPathClip(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize() // Ensure the layout wraps its content
            .clip()// Clip the layout with the custom path
    ) {
        // Add content to be clipped
        content()
    }
}

@Composable
fun CustomPathClipPath(): Modifier {
    return Modifier.drawWithContent {
        val path = Path().apply {
            // Define your custom path (e.g., rounded rectangle)
            addRoundRect(android.graphics.RectF(100f, 100f, 300f, 200f), 20f, 20f, Path.Direction.CW)
        }

        // Clip the content with the custom path
        clipPath(path) {
            // Draw the content inside the clipped area
            drawContent() // This draws the content passed to CustomPathClip
        }
    }
}

@Composable
fun CustomPathClipDemo() {
    CustomPathClip {
        Text("Bounded Text Field", modifier = Modifier.padding(16.dp))
        // Add other composables like text fields here
    }
}
*/
