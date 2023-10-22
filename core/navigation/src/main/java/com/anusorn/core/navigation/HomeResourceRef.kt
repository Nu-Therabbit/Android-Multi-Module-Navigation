package com.anusorn.core.navigation

import androidx.annotation.IdRes

interface HomeResourceRef {
    @IdRes
    fun startDestinationGraph(): Int

    @IdRes
    fun aboutDestination(): Int

    @IdRes
    fun detailDestination(): Int
}
