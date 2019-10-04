package com.fetchrewards.dug.simplesort.ui.main

import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fetchrewards.dug.simplesort.R
import com.fetchrewards.dug.simplesort.app.factory.Factory
import com.fetchrewards.dug.simplesort.ui.common.mvc.ObservableViewMvcImpl
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc


class MainViewMvcImpl(
    factory: Factory,
    override val rootView: ViewGroup
) : ObservableViewMvcImpl<MainViewMvc.Listener>(),
    MainViewMvc,
    MainListAdapter.Listener {

    private val listView = findViewById<RecyclerView>(R.id.listView)
    private val adapter = MainListAdapter(factory, this)

    init {
        val layoutManager = LinearLayoutManager(rootView.context)
        listView.layoutManager = layoutManager
        listView.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))
        listView.adapter = adapter
    }

    // region MainViewMvc

    override fun notifyDataSetChanged() {
        adapter.notifyDataSetChanged()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (listeners.isNotEmpty()) {
            menu?.findItem(R.id.action_sort)?.let { item ->
                item.title = listeners.first().sortMenuTitle
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        listeners.forEach { listener -> listener.onToggleSort() }
        return true
    }

    // endregion MainViewMvc

    // region MainListAdapter.Listener

    override val numItems: Int
        get() = if (listeners.isEmpty()) 0 else listeners.first().numItems

    override fun onBindItem(itemViewMvc: MainItemViewMvc, position: Int) {
        listeners.forEach { listener -> listener.onBindItem(itemViewMvc, position) }
    }

    // endregion MainListAdapter.Listener
}