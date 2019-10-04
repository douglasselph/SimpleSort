package com.fetchrewards.dug.simplesort.ui.main

import android.view.Menu
import android.view.MenuItem
import com.fetchrewards.dug.simplesort.ui.common.mvc.ObservableViewMvc
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc

interface MainViewMvc :
    ObservableViewMvc<MainViewMvc.Listener> {

    interface Listener {
        val numItems: Int
        fun onBindItem(itemViewMvc: MainItemViewMvc, position: Int)

        fun onToggleSort()
        val sortMenuTitle: String
    }

    fun onPrepareOptionsMenu(menu: Menu?): Boolean
    fun onOptionsItemSelected(item: MenuItem): Boolean
    fun notifyDataSetChanged()

}