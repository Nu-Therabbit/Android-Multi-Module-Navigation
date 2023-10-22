package com.anusorn.multimodulenavigation.navigation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import com.anusorn.core.navigation.HomeResourceRef
import com.anusorn.core.navigation.TopLevelSettingDirections

class TopLevelSettingNavigation(private val homeResourceRef: HomeResourceRef) :
    TopLevelSettingDirections {
    override fun navigationHomeGraph(navController: NavController) {
        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
        navController.navigate(
            homeResourceRef.startDestinationGraph(),
            Bundle.EMPTY,
            topLevelNavOptions
        )
    }
}
