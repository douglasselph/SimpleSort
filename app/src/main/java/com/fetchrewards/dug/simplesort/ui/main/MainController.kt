package com.fetchrewards.dug.simplesort.ui.main

import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.fetchrewards.dug.simplesort.R
import com.fetchrewards.dug.simplesort.model.person.Person
import com.fetchrewards.dug.simplesort.services.computation.MySort
import com.fetchrewards.dug.simplesort.services.people.FetchPeople
import com.fetchrewards.dug.simplesort.ui.common.wrapper.Binder
import com.fetchrewards.dug.simplesort.ui.common.wrapper.StringWrapper
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc

/**
 * All logic is centered into this file so that a unit test from this can be easily constructed at a later point
 * when there is something more interesting to do.
 */
class MainController(
    private val viewMvc: MainViewMvc,
    binder: Binder,
    private val wrapper: StringWrapper,
    private val fetchPeople: FetchPeople,
    private val sorter: MySort
) : LifecycleObserver,
    MainViewMvc.Listener {

    private var people = listOf<Person>()
    private var isSorting = true

    init {
        binder.bindObserver(this)
    }

    // region Controller

    var invalidateOptionsMenu: () -> Unit = {}

    fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return viewMvc.onPrepareOptionsMenu(menu)
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        return viewMvc.onOptionsItemSelected(item)
    }

    // endregion Controller

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
            this.people = if (isSorting) {
                sorter.sort(people)
            } else {
                people
            }
            viewMvc.notifyDataSetChanged()
        }
    }

    // region MainViewMvc.Listener

    override val numItems: Int
        get() = people.size

    override fun onBindItem(itemViewMvc: MainItemViewMvc, position: Int) {
        val person = people[position]
        itemViewMvc.age = person.age.toString()
        itemViewMvc.name = person.name ?: wrapper.getString(R.string.null_name)
    }

    override fun onToggleSort() {
        isSorting = !isSorting
        acquire()
        invalidateOptionsMenu()
    }

    override val sortMenuTitle: String
        get() = if (isSorting) wrapper.getString(R.string.action_unsort) else wrapper.getString(R.string.action_sort)

    // endregion MainViewMvc.Listener
}
