package com.fetchrewards.dug.simplesort.services.computation

import com.fetchrewards.dug.simplesort.model.person.Person

interface MySort {

    fun sort(people: List<Person>): List<Person>
}