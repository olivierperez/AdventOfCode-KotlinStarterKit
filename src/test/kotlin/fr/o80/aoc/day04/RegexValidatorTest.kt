package fr.o80.aoc.day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RegexValidatorTest {
    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // Given
        val validator = RegexValidator("^([a-zA-Z])(\\d{0,4})$")

        // When Then
        assertFalse(validator.isValid(null))
        assertFalse(validator.isValid("9"))
        assertFalse(validator.isValid("A12345"))
        assertFalse(validator.isValid("AB12"))
        assertFalse(validator.isValid("A-45"))

        assertTrue(validator.isValid("X"))
        assertTrue(validator.isValid("a1"))
        assertTrue(validator.isValid("B1234"))
        assertTrue(validator.isValid("F958"))
        assertTrue(validator.isValid("T20"))
    }
}