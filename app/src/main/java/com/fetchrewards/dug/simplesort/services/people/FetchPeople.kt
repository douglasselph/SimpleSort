package com.fetchrewards.dug.simplesort.services.people

import com.fetchrewards.dug.simplesort.model.person.Person

interface FetchPeople {

    fun fetchPeople(listener: (people: List<Person>) -> Unit)

}