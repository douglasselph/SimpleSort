package com.fetchrewards.dug.simplesort.services.computation

import com.fetchrewards.dug.simplesort.model.person.Person

class MySortImpl : MySort {

    // region MySort

    override fun sort(people: List<Person>): List<Person> =
        people.sortedWith(compareBy({ it.age }, { it.name }))

    // endregion MySort
}