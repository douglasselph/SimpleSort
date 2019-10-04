package com.fetchrewards.dug.simplesort.services.people

import com.fetchrewards.dug.simplesort.model.person.Person

class FetchPeopleImpl : FetchPeople {

    private val sampleGroup = listOf(
        Person(12, "Elder Son Jones"),
        Person(80, "Grandma Jones"),
        Person(10, "Daughter Jones"),
        Person( 100, ""),
        Person(35, "Uncle Jones"),
        Person(30, "Mother Jones"),
        Person(80, "Grandfather Jones"),
        Person(0, null),
        Person(9, "Twin Son Jones"),
        Person(1, "Baby Jones"),
        Person(30, "Father Jones"),
        Person(9, "Twin Daughter Jones")
    )
    // region FetchPeople

    override fun fetchPeople(listener: (people: List<Person>) -> Unit) {
        listener.invoke(sampleGroup)
    }

    // endregion FetchPeople
}