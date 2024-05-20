package com.example.navapp2.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.navapp2.ui.theme.NavApp2Theme
import com.playmoweb.multidatepicker.DateRangePickerr
import com.playmoweb.multidatepicker.MultiDatePicker
import com.playmoweb.multidatepicker.utils.extensions.DAY_YEAR
import com.playmoweb.multidatepicker.utils.extensions.asString
import java.util.Calendar
import java.util.Date

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var navController = rememberNavController()

            Log.d("lbkmbfgbv",Date(System.currentTimeMillis()).asString(DAY_YEAR).toString())

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = 1716211710233
            val selectedDate = calendar.time

            calendar.timeInMillis = 1715211710233
            val selectedDate2 = calendar.time

            NavApp2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    var selectedDates = remember {
                        mutableStateListOf<Date?>(selectedDate,selectedDate2)
                    }

                    Column() {
                        DateRangePickerr(onRangeSelected = {startDate, endDate ->
                            Log.d("lvmkfbmgbg",startDate.toString() + "  " + endDate.toString())
                        })
                        MultiDatePicker(selectedDates = selectedDates)

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

