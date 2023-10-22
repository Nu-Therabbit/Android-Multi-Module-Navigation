package com.anusorn.feature.home.navigation

import com.anusorn.core.navigation.HomeResourceRef
import com.anusorn.feature.home.R

class HomeResourceReference : HomeResourceRef {
    override fun startDestinationGraph(): Int = R.id.home_nav_graph
    override fun aboutDestination(): Int = R.id.homeAboutFragment
    override fun detailDestination(): Int = R.id.homeDetailFragment
}
