package fr.o80.aoc.kit.rangequery

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RangeQueryTest {

    @Test
    @DisplayName("Should compute with XOR operator")
    fun shouldTestXor() {
        // Given
        val key = listOf(11, 22, 33, 44, 55)
        val mutations = listOf(1..3, 0..1, 2..2, 2..4)

        val rangeQuery = RangeQuery(
            key,
            initial = 0,
            applyMutation = { a, b -> a xor b },
            unapplyMutation = { a, b -> b xor a }
        )

        // When
        val computed = rangeQuery.compute(mutations)

        // then
        assertEquals(27, computed[0])
        assertEquals(29, computed[1])
        assertEquals(33, computed[2])
        assertEquals(58, computed[3])
    }

    @Test
    @DisplayName("Should compute with + and - operators")
    fun shouldTestSum() {
        // Given
        val key = listOf(35, 20, 15)
        val mutations = listOf(0..1, 0..2, 1..2)

        val rangeQuery = RangeQuery(
            key,
            initial = 0,
            applyMutation = { a, b -> a + b },
            unapplyMutation = { a, b -> b - a }
        )

        // When
        val computed = rangeQuery.compute(mutations)

        // then
        assertEquals(55, computed[0])
        assertEquals(70, computed[1])
        assertEquals(35, computed[2])
    }

}
