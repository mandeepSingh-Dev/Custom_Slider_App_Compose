package com.example.navapp2.Graph.nestedGraphs

import com.example.navapp2.Graph.screensEnum.HomeScreens

sealed class NavGraphHome(val route : String) {
    data object LeftRightTrapezodiumsScreen : NavGraphHome(HomeScreens.LeftRightTrapezodiumsScreen.name)
    data object MoveImageScreen : NavGraphHome(HomeScreens.MoveImage.name)
    data object SharedComponentScreen : NavGraphHome(HomeScreens.SharedComponentScreen.name)
    data object SharedElementApp_BoundsTransformExample : NavGraphHome(HomeScreens.SharedElementAppBoundsTransformExampleScreen.name)
    data object SharedElement_Clipping : NavGraphHome(HomeScreens.SharedElementClippingScreen.name)
    data object SharedElement_SkipLookaheadSize : NavGraphHome(HomeScreens.SharedElementSkipLookaheadSizeScreen.name)
    data object PlaceholderSizeAnimated_Demo : NavGraphHome(HomeScreens.PlaceholderSizeAnimatedDemoScreen.name)
    data object customTextSharedElelement : NavGraphHome(HomeScreens.CustomTextSharedElelementScreen.name)

    companion object{
        val GraphRoute = "NavGraphHome"
    }
}

