package com.fetchrewards.dug.simplesort.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fetchrewards.dug.simplesort.app.factory.Factory
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc

/**
 * The listener allows all active logic to be kept within the controller.
 */
class MainListAdapter(
    private val factory: Factory,
    private val listener: Listener
) : RecyclerView.Adapter<MainListAdapter.MyViewHolder>() {

    interface Listener {
        val numItems: Int
        fun onBindItem(itemViewMvc: MainItemViewMvc, position: Int)
    }

    class MyViewHolder(val viewMvc: MainItemViewMvc) : RecyclerView.ViewHolder(viewMvc.rootView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            factory.allocMainItemViewMvc(
                parent
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        listener.onBindItem(holder.viewMvc, position)
    }

    override fun getItemCount(): Int {
        return listener.numItems
    }


}