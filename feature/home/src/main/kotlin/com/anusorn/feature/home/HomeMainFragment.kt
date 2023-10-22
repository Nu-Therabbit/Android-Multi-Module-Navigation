package com.anusorn.feature.home

import android.view.View
import android.widget.TextView
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.anusorn.core.base.BaseDemoFragment
import com.anusorn.core.base.BaseDemoViewModel
import com.anusorn.core.base.bindNavArgsCustomParams
import com.anusorn.core.base.viewBinding
import com.anusorn.core.navigation.TopLevelHomeDirections
import com.anusorn.feature.home.databinding.FragmentHomeMainBinding
import com.google.android.material.textfield.TextInputEditText
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeMainFragment : BaseDemoFragment(R.layout.fragment_home_main) {

    private val binding by viewBinding<FragmentHomeMainBinding>()
    private val navArgs: HomeMainFragmentArgs by navArgs()
    private val viewModel: HomeMainViewModel by viewModel { parametersOf(navArgs.customParams) }
    private val topLevelHomeNavigation: TopLevelHomeDirections by inject()

    override val titleTextView: TextView
        get() = binding.baseView.titleTextView
    override val previewStateTextView: TextView
        get() = binding.baseView.previewStateTextView
    override val backStackTextView: TextView
        get() = binding.baseView.backStackTextView
    override val navigationParamsTextView: TextView
        get() = binding.baseView.navigationParamsTextView
    override val textInputEditText: TextInputEditText
        get() = binding.baseView.textInputEditText
    override val baseDemoViewModel: BaseDemoViewModel
        get() = viewModel

    override fun setUpView() {
        super.setUpView()
        with(binding.baseView) {
            homeGraphButton.visibility = View.GONE
            homeDetailButton.visibility = View.GONE
            settingUserButton.visibility = View.GONE
            settingDeviceButton.visibility = View.GONE
            homeAboutButton.setOnClickListener {
                val action = HomeMainFragmentDirections.actionHomeMainFragmentToHomeAboutFragment(
                    bindNavArgsCustomParams()
                )
                findNavController().navigate(action)
            }
            settingGraphButton.setOnClickListener {
                topLevelHomeNavigation.navigationSettingGraph(findNavController())
            }
        }
    }
}
