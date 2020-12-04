package fr.o80.aoc.day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class EnumValidatorTest {
    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // Given
        val validator = EnumValidator(arrayOf("1","2","3"))

        // When Then
        assertFalse(validator.isValid(null))
        assertFalse(validator.isValid("9"))
        assertFalse(validator.isValid("21"))
        assertFalse(validator.isValid("2A"))

        assertTrue(validator.isValid("1"))
        assertTrue(validator.isValid("2"))
        assertTrue(validator.isValid("3"))
    }
}