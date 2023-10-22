package com.anusorn.core.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            init()
        } else {
            restoreView(savedInstanceState)
        }
        setUpInstance()
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        observeViewModel()
    }

    open fun setUpInstance() = Unit
    open fun setUpView() = Unit
    open fun observeViewModel() = Unit
    open fun init() = Unit
    open fun restoreView(savedInstanceState: Bundle?) = Unit
}
