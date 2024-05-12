package com.example.navapp2.utils

import android.content.Context
import androidx.compose.runtime.Composable

fun Float.toPx(context : Context): Float {
    val density = context.resources.displayMetrics.density
    return this*density
}
@Composable
fun Float.toDp(context: Context): Float {
    val density = context.resources.displayMetrics.density
    return (this)/density
}
