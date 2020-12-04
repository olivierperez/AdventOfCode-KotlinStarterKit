package fr.o80.aoc.day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class IntValidatorTest {
    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // Given
        val validator = IntValidator { it in 10..20 }

        // When Then
        assertFalse(validator.isValid(null))
        assertFalse(validator.isValid("9"))
        assertFalse(validator.isValid("21"))
        assertFalse(validator.isValid("2A"))

        assertTrue(validator.isValid("10"))
        assertTrue(validator.isValid("12"))
        assertTrue(validator.isValid("19"))
        assertTrue(validator.isValid("20"))
    }
}