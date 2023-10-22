package com.anusorn.core.base

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.bindNavArgsCustomParams(): String {
    val str = findNavController().currentBackStack.value.map {
        val name = it.destination.displayName.substringAfter(":id/")
        return@map buildString {
            append(name)
        }
    }.toString()
    return buildString {
        append(str)
    }
}
