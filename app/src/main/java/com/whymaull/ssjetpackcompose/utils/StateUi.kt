package com.whymaull.ssjetpackcompose.utils

sealed class StateUi <out T : Any?> {

    object Load : StateUi<Nothing>()

    data class Success<out T : Any>(val data : T) : StateUi<T>()

    data class Error(val message : String) : StateUi<Nothing>()
}