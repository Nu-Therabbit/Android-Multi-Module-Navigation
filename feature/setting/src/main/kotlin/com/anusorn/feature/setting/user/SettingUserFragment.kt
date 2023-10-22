package com.anusorn.feature.setting.user

import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.anusorn.core.base.BaseDemoFragment
import com.anusorn.core.base.BaseDemoViewModel
import com.anusorn.core.base.bindNavArgsCustomParams
import com.anusorn.core.base.viewBinding
import com.anusorn.core.navigation.TopLevelSettingDirections
import com.anusorn.feature.setting.R
import com.anusorn.feature.setting.databinding.FragmentSettingUserBinding
import com.google.android.material.textfield.TextInputEditText
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SettingUserFragment : BaseDemoFragment(R.layout.fragment_setting_user) {

    private val binding by viewBinding<FragmentSettingUserBinding>()
    private val args: SettingUserFragmentArgs by navArgs()
    private val viewModel: SettingUserViewModel by viewModel { parametersOf(args.customParams) }
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
            settingDeviceButton.setOnClickListener {
                val action =
                    SettingUserFragmentDirections.actionSettingUserFragmentToSettingDeviceFragment(
                        bindNavArgsCustomParams()
                    )
                findNavController().navigate(action)
            }
            homeGraphButton.setOnClickListener {
                topLevelSettingDirections.navigationHomeGraph(findNavController())
            }
        }
    }
}
