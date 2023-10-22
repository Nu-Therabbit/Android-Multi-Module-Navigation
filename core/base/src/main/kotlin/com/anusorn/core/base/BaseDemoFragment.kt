package com.anusorn.core.base

import android.os.Bundle
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class BaseDemoFragment(@LayoutRes layoutId: Int) : BaseFragment(layoutId) {
    protected abstract val titleTextView: TextView
    protected abstract val previewStateTextView: TextView
    protected abstract val backStackTextView: TextView
    protected abstract val navigationParamsTextView: TextView
    protected abstract val textInputEditText: TextInputEditText
    protected abstract val baseDemoViewModel: BaseDemoViewModel

    override fun setUpInstance() {
        baseDemoViewModel.setScreenName(this.toString().substringBeforeLast("("))
        baseDemoViewModel.setBackStack(bindNavArgsCustomParams())
    }

    override fun setUpView() {
        findNavController().addOnDestinationChangedListener { controller, _, _ ->
            baseDemoViewModel.setBackStack(
                controller.currentBackStack.value.map {
                    val name = it.destination.displayName.substringAfter(":id/")
                    return@map buildString {
                        append(name)
                    }
                }.toString()
            )
        }
        textInputEditText.doAfterTextChanged {
            baseDemoViewModel.updatePreviewState(it.toString())
        }
    }

    override fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                baseDemoViewModel.titleText.collect {
                    titleTextView.text = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                baseDemoViewModel.previewStateText.collectLatest {
                    previewStateTextView.text = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                baseDemoViewModel.backStackText.collect {
                    backStackTextView.text = it
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                baseDemoViewModel.navigationParamsText.collect {
                    navigationParamsTextView.text = it
                }
            }
        }
    }
}
