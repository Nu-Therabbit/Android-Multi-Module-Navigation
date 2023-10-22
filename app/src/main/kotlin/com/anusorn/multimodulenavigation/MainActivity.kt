package com.anusorn.multimodulenavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.anusorn.core.base.viewBinding
import com.anusorn.core.navigation.HomeResourceRef
import com.anusorn.core.navigation.SettingResourceRef
import com.anusorn.multimodulenavigation.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("RestrictedApi")
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: MainViewModel by viewModel()
    private val navController by lazy { findNavController(R.id.navHostFragment) }
    private val homeResourceRef: HomeResourceRef by inject()
    private val settingResourceRef: SettingResourceRef by inject()
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                homeResourceRef.startDestinationGraph(),
                settingResourceRef.startDestinationGraph()
            ),
            binding.drawerLayout
        )
        setSupportActionBar(binding.topAppBar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun findNavController(@IdRes viewId: Int) =
        (supportFragmentManager.findFragmentById(viewId) as? NavHostFragment)?.navController
            ?: Navigation.findNavController(this, viewId)
}
