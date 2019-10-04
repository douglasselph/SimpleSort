package com.fetchrewards.dug.simplesort.ui.common.wrapper

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Binder(
    private val context: LifecycleOwner
) {

    fun bindObserver(observer: LifecycleObserver): LifecycleObserver {
        context.lifecycle.addObserver(observer)
        return observer
    }

}