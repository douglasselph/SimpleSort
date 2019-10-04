package com.fetchrewards.dug.simplesort.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fetchrewards.dug.simplesort.R
import com.fetchrewards.dug.simplesort.app.factory.Factory
import com.fetchrewards.dug.simplesort.ui.common.mvc.ObservableViewMvcImpl
import com.fetchrewards.dug.simplesort.ui.common.VerticalSpaceItemDecoration
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc

class MainViewMvcImpl(
    factory: Factory,
    override val rootView: ViewGroup
) : ObservableViewMvcImpl<MainViewMvc.Listener>(),
    MainViewMvc,
    MainListAdapter.Listener {

    private val listView = findViewById<RecyclerView>(R.id.listView)
    private val adapter = MainListAdapter(factory, this)
    private val vSpace = context.resources.getDimension(R.dimen.item_gap).toInt()

    init {
        listView.layoutManager = LinearLayoutManager(rootView.context)
        listView.addItemDecoration(
            VerticalSpaceItemDecoration(
                vSpace
            )
        )
        listView.adapter = adapter
    }

    // region MainViewMvc

    override fun notifyDataSetChanged() {
        adapter.notifyDataSetChanged()
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