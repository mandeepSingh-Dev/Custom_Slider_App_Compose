package com.example.navapp2.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.navapp2.Graph.nestedGraphs.NavGraphCommon
import com.example.navapp2.Graph.nestedGraphs.NavGraphHome
import com.example.navapp2.Graph.screensEnum.HomeScreens
import com.example.navapp2.ui.EnterExitJetsnack
import com.example.navapp2.ui.FamilyAddScreen
import com.example.navapp2.ui.PlaceholderSizeAnimated_Demo
import com.example.navapp2.ui.SharedElement2
import com.example.navapp2.ui.SharedElementApp_BoundsTransformExample
import com.example.navapp2.ui.SharedElement_Clipping
import com.example.navapp2.ui.SharedElement_SkipLookaheadSize
import com.example.navapp2.ui.common.screens.AnimateProgressButton
import com.example.navapp2.ui.common.screens.ZeroWidthToFullWidthAnimation
import com.example.navapp2.ui.composableFun
import com.example.navapp2.ui.customTextSharedElelement
import com.example.navapp2.ui.home.screens.LeftRightTrapezodiumsScreen
import com.example.navapp2.ui.home.screens.moveImage
import com.example.navapp2.ui.home.screens.sharedComponent
import com.example.navapp2.ui.theme.NavApp2Theme
import com.playmoweb.multidatepicker.MultiDatePicker

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
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

                    Column {
                        MultiDatePicker()
                    }

/*
                    NavHost(navController = navController, startDestination = NavGraphHome.GraphRoute){

                        //Common Nested NavGraph
                        navigation(
                            startDestination = NavGraphCommon.AnimateProgressButtonScreen.route,
                            route = NavGraphCommon.GraphRoute) {
                            composable(route = NavGraphCommon.AnimateProgressButtonScreen.route){
                                AnimateProgressButton( onNavigate = {
                                    navController.navigate(it)
                                })
                            }
                            composable(route = NavGraphCommon.ZeroWidthToFullWidthAnimation.route){
                                ZeroWidthToFullWidthAnimation( onNavigate = {
                                    navController.navigate(it)
                                })
                            }
                        }

                        navigation(startDestination = NavGraphHome.LeftRightTrapezodiumsScreen.route, route = NavGraphHome.GraphRoute){

                            composable(
                                route = NavGraphHome.LeftRightTrapezodiumsScreen.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                                LeftRightTrapezodiumsScreen(onNavigate = {
                                    navController.navigate(it)
                                })
                            }

                            composable(
                                route = NavGraphHome.MoveImageScreen.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                                moveImage(){
                                    navController.navigate(it)
                                }

                            }

                            composable(
                                route = NavGraphHome.SharedComponentScreen.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                                sharedComponent{
                                    navController.navigate(it)

                                }
                            }
 composable(
                                route = NavGraphHome.SharedElementApp_BoundsTransformExample.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                                SharedElementApp_BoundsTransformExample {
                                    navController.navigate(it)
                                }
                            }
                            composable(
                                route = NavGraphHome.SharedElement_Clipping.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                                SharedElement_Clipping {
                                    navController.navigate(it)
                                }
                            }

                       composable(
                                route = NavGraphHome.SharedElement_SkipLookaheadSize.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                                SharedElement_SkipLookaheadSize {
                                    navController.navigate(it)
                                }
                            }

                       composable(
                                route = NavGraphHome.PlaceholderSizeAnimated_Demo.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                                PlaceholderSizeAnimated_Demo {
                                    navController.navigate(it)
                                }
                            }

                       composable(
                                route = NavGraphHome.customTextSharedElelement.route,
                                enterTransition = { scaleIn() },
                                exitTransition = { scaleOut() },
                                popEnterTransition = { scaleIn() },
                                popExitTransition = { scaleOut() }
                            ){
                           customTextSharedElelement()
                            }
                        }
                    }
*/
                }
            }
        }
    }
}



/*
NavHost(navController = navController, startDestination = "LeftTra"){

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



/*
DisposableLifecycleEventObserver(
onCreate = { Log.d("fblkbmg","onCreate")*//*TODO*//* },
onStart = { Log.d("fblkbmg","onStart")*//*TODO*//* },
onResume = {Log.d("fblkbmg","onResume") *//*TODO*//* },
onPause = { Log.d("fblkbmg","onPause")*//*TODO*//* },
onStop = { Log.d("fblkbmg","onStop")*//*TODO*//* },
onDestroy = { Log.d("fblkbmg","onDestroy")*//*TODO*//*
    Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show()},
onAny = { Log.d("fblkbmg","onAny =")*//*TODO*//* },
onDisposeCompose = { Log.d("fblkbmg","onDisposeCompose")*//*TODO*//* }
)*/

