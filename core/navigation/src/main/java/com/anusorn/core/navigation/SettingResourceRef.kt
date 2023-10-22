package com.anusorn.core.navigation

import androidx.annotation.IdRes

interface SettingResourceRef {
    @IdRes
    fun startDestinationGraph(): Int

    @IdRes
    fun userDestination(): Int

    @IdRes
    fun deviceDestination(): Int
}
