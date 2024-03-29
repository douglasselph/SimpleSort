package com.fetchrewards.dug.simplesort.app.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.fetchrewards.dug.simplesort.services.computation.MySort
import com.fetchrewards.dug.simplesort.services.computation.MySortImpl
import com.fetchrewards.dug.simplesort.services.people.FetchPeople
import com.fetchrewards.dug.simplesort.services.people.FetchPeopleImpl
import com.fetchrewards.dug.simplesort.ui.common.wrapper.Binder
import com.fetchrewards.dug.simplesort.ui.common.wrapper.StringWrapper
import com.fetchrewards.dug.simplesort.ui.main.MainController
import com.fetchrewards.dug.simplesort.ui.main.MainViewMvc
import com.fetchrewards.dug.simplesort.ui.main.MainViewMvcImpl
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvc
import com.fetchrewards.dug.simplesort.ui.main.item.MainItemViewMvcImpl

// Note: as this app develops this class would expand out to full dependency injection
class Factory(
    act: AppCompatActivity,
    private val inflater: LayoutInflater
) {

    private val binder = Binder(act)
    private val stringWrapper = StringWrapper(act)

    // region public alloc

    fun allocMainItemViewMvc(parent: ViewGroup?): MainItemViewMvc {
        return MainItemViewMvcImpl(inflater, parent)
    }

    fun allocMainViewMvc(parent: ViewGroup): MainViewMvc {
        return MainViewMvcImpl(this, parent)
    }

    fun allocMainController(viewMvc: MainViewMvc): MainController {
        return MainController(
            viewMvc,
            binder,
            stringWrapper,
            allocFetchPeople(),
            allocSort()
        )
    }

    // endregion public alloc

    private fun allocFetchPeople(): FetchPeople {
        return FetchPeopleImpl()
    }

    private fun allocSort(): MySort {
        return MySortImpl()
    }

}