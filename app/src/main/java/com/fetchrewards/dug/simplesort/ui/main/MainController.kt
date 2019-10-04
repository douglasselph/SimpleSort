package com.fetchrewards.dug.simplesort.ui.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.fetchrewards.dug.simplesort.model.person.Person
import com.fetchrewards.dug.simplesort.services.computation.MySort
import com.fetchrewards.dug.simplesort.services.people.FetchPeople
import com.fetchrewards.dug.simplesort.ui.common.wrapper.Binder
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc

class MainController(
    binder: Binder,
    private val viewMvc: MainViewMvc,
    private val fetchPeople: FetchPeople,
    private val sorter: MySort
) : LifecycleObserver,
    MainViewMvc.Listener {

    private var people = listOf<Person>()

    init {
        binder.bindObserver(this)
    }

    // region Lifecycle

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        viewMvc.registerListener(this)
        acquire()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        viewMvc.unregisterListener(this)
    }

    // endregion Lifecycle

    private fun acquire() {
        fetchPeople.fetchPeople { people ->
            this.people = sorter.sort(people)
            viewMvc.notifyDataSetChanged()
        }
    }

    // region MainViewMvc.Listener

    override val numItems: Int
        get() = people.size

    override fun onBindItem(itemViewMvc: MainItemViewMvc, position: Int) {
        val person = people[position]
        itemViewMvc.age = person.age.toString()
        itemViewMvc.name = person.name
    }

    // endregion MainViewMvc.Listener
}
