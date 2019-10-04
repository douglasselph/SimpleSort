package com.fetchrewards.dug.simplesort.services.computation

import com.fetchrewards.dug.simplesort.model.person.Person
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MySortImplTest {

    private val unsortedGroup = listOf(
        Person(12, "Elder Son Jones"),
        Person(80, "Grandma Jones"),
        Person(10, "Daughter Jones"),
        Person(80, "Grandfather Jones")
    )
    private val sortedGroup = listOf(
        Person(10, "Daughter Jones"),
        Person(12, "Elder Son Jones"),
        Person(80, "Grandfather Jones"),
        Person(80, "Grandma Jones")
    )

    private lateinit var sort: MySort

    @Before
    fun setUp() {
        sort = MySortImpl()
    }

    @Test
    fun sort_verify() {
        // Arrange
        // Act
        val items = sort.sort(unsortedGroup)
        // Assert
        assertEquals(sortedGroup, items)
    }

}