package com.fetchrewards.dug.simplesort.ui.main

import com.fetchrewards.dug.simplesort.ui.common.mvc.ObservableViewMvc
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc

interface MainViewMvc :
    ObservableViewMvc<MainViewMvc.Listener> {

    interface Listener {
        val numItems: Int
        fun onBindItem(itemViewMvc: MainItemViewMvc, position: Int)
    }

    fun notifyDataSetChanged()

}