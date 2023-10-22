package com.anusorn.feature.setting.device

import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.anusorn.core.base.BaseDemoFragment
import com.anusorn.core.base.BaseDemoViewModel
import com.anusorn.core.base.viewBinding
import com.anusorn.core.navigation.TopLevelSettingDirections
import com.anusorn.feature.setting.R
import com.anusorn.feature.setting.databinding.FragmentSettingDeviceBinding
import com.google.android.material.textfield.TextInputEditText
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SettingDeviceFragment : BaseDemoFragment(R.layout.fragment_setting_device) {

    private val binding by viewBinding<FragmentSettingDeviceBinding>()
    private val navArgs: SettingDeviceFragmentArgs by navArgs()
    private val viewModel: SettingDeviceViewModel by viewModel { parametersOf(navArgs.customParams) }
    private val topLevelSettingDirections by inject<TopLevelSettingDirections>()

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
            homeAboutButton.visibility = View.GONE
            homeDetailButton.visibility = View.GONE
            settingGraphButton.visibility = View.GONE
            settingUserButton.visibility = View.GONE
            settingDeviceButton.visibility = View.GONE
            homeGraphButton.setOnClickListener {
                topLevelSettingDirections.navigationHomeGraph(findNavController())
            }
        }
    }
}
