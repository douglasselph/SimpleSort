package com.fetchrewards.dug.simplesort.ui.common.mvc

interface ObservableViewMvc<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)

}
