package fr.o80.aoc.kit.rangequery

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RangeQueryTest {

    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // Given
        val key = listOf(11, 22, 33, 44, 55)
        val mutations = listOf(1..3, 0..1, 2..2, 2..4)

        val rangeQuery = RangeQuery(
            key,
            applyMutation = { a, b -> a xor b },
            unapplyMutation = { b, a -> a xor b }
        )

        // When
        val computed = rangeQuery.compute(mutations)

        // then
        assertEquals(27, computed[0])
        assertEquals(29, computed[1])
        assertEquals(33, computed[2])
        assertEquals(58, computed[3])
    }

}