package com.anusorn.multimodulenavigation.navigation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import com.anusorn.core.navigation.SettingResourceRef
import com.anusorn.core.navigation.TopLevelHomeDirections

class TopLevelHomeNavigation(private val settingResourceRef: SettingResourceRef) :
    TopLevelHomeDirections {
    override fun navigationSettingGraph(navController: NavController) {
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
            settingResourceRef.startDestinationGraph(),
            Bundle.EMPTY,
            topLevelNavOptions
        )
    }
}
