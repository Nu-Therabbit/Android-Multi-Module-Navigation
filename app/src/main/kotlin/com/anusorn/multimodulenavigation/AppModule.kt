package com.anusorn.multimodulenavigation

import com.anusorn.core.navigation.TopLevelHomeDirections
import com.anusorn.core.navigation.TopLevelSettingDirections
import com.anusorn.multimodulenavigation.navigation.TopLevelHomeNavigation
import com.anusorn.multimodulenavigation.navigation.TopLevelSettingNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel() }
    single<TopLevelHomeDirections> { TopLevelHomeNavigation(get()) }
    single<TopLevelSettingDirections> { TopLevelSettingNavigation(get()) }
}
