package fr.o80.aoc.kit.knapsack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class KnapsackTest {

    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // Given
        val knapsack = Knapsack(
            capacity = 8,
            items = listOf(2, 3, 4),
            interestOf = { it },
            costOf = { it }
        )

        // When
        val (value, chosenItems) = knapsack.compute()

        // then
        assertEquals(7, value)
        assertTrue(3 in chosenItems)
        assertTrue(4 in chosenItems)
    }

}