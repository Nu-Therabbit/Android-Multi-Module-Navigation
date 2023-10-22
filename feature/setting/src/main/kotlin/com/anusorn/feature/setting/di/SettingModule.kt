package com.anusorn.feature.setting.di

import com.anusorn.core.navigation.SettingResourceRef
import com.anusorn.feature.setting.SettingMainViewModel
import com.anusorn.feature.setting.device.SettingDeviceViewModel
import com.anusorn.feature.setting.navigation.SettingResourceReference
import com.anusorn.feature.setting.user.SettingUserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingModule = module {
    single<SettingResourceRef> { SettingResourceReference() }
    viewModel { (params: String) -> SettingMainViewModel(params) }
    viewModel { (params: String) -> SettingUserViewModel(params) }
    viewModel { (params: String) -> SettingDeviceViewModel(params) }
}
