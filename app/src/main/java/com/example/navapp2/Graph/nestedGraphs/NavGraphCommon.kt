package com.example.navapp2.Graph.nestedGraphs

import com.example.navapp2.Graph.screensEnum.CommonScreens

sealed class NavGraphCommon(val route : String){
    data object AnimateProgressButtonScreen : NavGraphCommon(route = CommonScreens.AnimateProgressButton.name)
    data object  ZeroWidthToFullWidthAnimation: NavGraphCommon(route = CommonScreens.ZeroWidthToFullWidthAnimation.name)

    companion object {
        val GraphRoute = "NavGraphCommon"
    }

}