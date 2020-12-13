package fr.o80.aoc.kit.math

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LcmKtTest {

    @Test
    @DisplayName("LCM of primes should be A*B")
    fun shouldComputeLCMOfPrimes() {
        // When
        assertEquals(2, lcm(1, 2))
        assertEquals(6, lcm(2, 3))
        assertEquals(21, lcm(3, 7))
        assertEquals(14, lcm(2, 7))
    }

    @Test
    @DisplayName("Check LCM of integers")
    fun shouldComputeLCMOfIntegers() {
        // When
        assertEquals(12, lcm(3, 4))
        assertEquals(12, lcm(6, 4))
        assertEquals(36, lcm(4, 9))
    }

}