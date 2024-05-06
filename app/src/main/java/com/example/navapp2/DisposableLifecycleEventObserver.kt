package com.example.navapp2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

@Composable
fun DisposableLifecycleEventObserver(
    onCreate : () -> Unit,
    onStart : () -> Unit,
    onResume : () -> Unit,
    onPause : () -> Unit,
    onStop : () -> Unit,
    onDestroy : () -> Unit,
    onAny : () -> Unit,
    onDisposeCompose : () -> Unit
) {
    var lifecycleOwner : LifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(key1 = lifecycleOwner, effect = {

        val lifecycleEventObserver = LifecycleEventObserver { source, event ->
            when(event){
                Lifecycle.Event.ON_CREATE -> {       onCreate() }
                Lifecycle.Event.ON_START -> { onStart() }
                Lifecycle.Event.ON_RESUME -> { onResume() }
                Lifecycle.Event.ON_PAUSE -> {   onPause() }
                Lifecycle.Event.ON_STOP -> {   onStop() }
                Lifecycle.Event.ON_DESTROY -> {  onDestroy() }
                Lifecycle.Event.ON_ANY -> {   onAny() }
            }
        }

        lifecycleOwner.lifecycle.addObserver(lifecycleEventObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifecycleEventObserver)
            onDisposeCompose()
        }
    })


}