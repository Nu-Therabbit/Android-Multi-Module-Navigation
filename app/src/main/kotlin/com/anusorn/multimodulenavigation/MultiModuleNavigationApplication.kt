package com.anusorn.multimodulenavigation

import android.app.Application
import com.anusorn.core.navigation.di.navigationModule
import com.anusorn.feature.home.di.homeModule
import com.anusorn.feature.setting.di.settingModule
import org.koin.core.context.startKoin

class MultiModuleNavigationApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule, navigationModule, homeModule, settingModule)
        }
    }
}
