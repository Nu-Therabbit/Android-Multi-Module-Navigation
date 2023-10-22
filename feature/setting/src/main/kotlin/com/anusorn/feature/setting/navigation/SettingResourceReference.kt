package com.anusorn.feature.setting.navigation

import com.anusorn.core.navigation.SettingResourceRef
import com.anusorn.feature.setting.R

class SettingResourceReference : SettingResourceRef {
    override fun startDestinationGraph(): Int = R.id.setting_nav_graph
    override fun userDestination(): Int = R.id.settingUserFragment
    override fun deviceDestination(): Int = R.id.settingDeviceFragment
}
