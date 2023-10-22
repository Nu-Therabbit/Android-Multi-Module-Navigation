package com.anusorn.feature.home.di

import com.anusorn.core.navigation.HomeResourceRef
import com.anusorn.feature.home.HomeMainViewModel
import com.anusorn.feature.home.about.HomeAboutViewModel
import com.anusorn.feature.home.detail.HomeDetailViewModel
import com.anusorn.feature.home.navigation.HomeResourceReference
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    single<HomeResourceRef> { HomeResourceReference() }
    viewModel { (params: String) -> HomeMainViewModel(params) }
    viewModel { (params: String) -> HomeAboutViewModel(params) }
    viewModel { (params: String) -> HomeDetailViewModel(params) }
}
