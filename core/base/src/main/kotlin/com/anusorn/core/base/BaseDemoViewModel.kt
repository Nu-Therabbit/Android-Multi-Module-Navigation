package com.anusorn.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseDemoViewModel(params: String?) : ViewModel() {

    companion object {
        private const val UNKNOWN = "Unknown"
    }

    private val _title = MutableStateFlow("This is $UNKNOWN fragment")
    val titleText: StateFlow<String>
        get() = _title

    private val _navigationParamsText = MutableStateFlow(
        params?.ifBlank {
            UNKNOWN
        } ?: UNKNOWN
    )
    val navigationParamsText: StateFlow<String>
        get() = _navigationParamsText

    private val _backStackText = MutableStateFlow(UNKNOWN)
    val backStackText: StateFlow<String>
        get() = _backStackText

    private val _previewStateText = MutableStateFlow(UNKNOWN)
    val previewStateText: StateFlow<String>
        get() = _previewStateText

    fun setScreenName(name: String) {
        _title.value = "This is $name"
    }

    fun setBackStack(str: String) {
        _backStackText.value = str
    }

    fun updatePreviewState(str: String) {
        _previewStateText.value = str
    }
}
