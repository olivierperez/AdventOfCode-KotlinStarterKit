package fr.o80.aoc.day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class WhateverValidatorTest {
    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // Given
        val validator = WhateverValidator

        // When Then
        assertTrue(validator.isValid(null))
        assertTrue(validator.isValid("9"))
        assertTrue(validator.isValid("21999999999999999qsdqsdq96dqs1 dqsd 1d 056eaze4\ndqsd"))
        assertTrue(validator.isValid("2A"))
        assertTrue(validator.isValid("10"))
        assertTrue(validator.isValid("12"))
        assertTrue(validator.isValid("19"))
        assertTrue(validator.isValid("20"))
    }
}