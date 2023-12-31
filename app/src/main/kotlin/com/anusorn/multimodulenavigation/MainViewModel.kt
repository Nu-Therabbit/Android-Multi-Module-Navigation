package com.anusorn.multimodulenavigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _topLevelScreen = MutableStateFlow(UiTopLevelScreen.HOME)
    val topLevelScreen: StateFlow<UiTopLevelScreen>
        get() = _topLevelScreen

    fun setScreen(screen: UiTopLevelScreen) {
        _topLevelScreen.value = screen
    }
}
