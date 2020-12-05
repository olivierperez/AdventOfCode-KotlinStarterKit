package fr.o80.aoc.kit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class IntsTest {
    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // Given
        val list = listOf(1, 5, 9, 45, -98, 978, 5, 4, -58)
        val seq = listOf(1, 5, 9, 45, -98, 978, 5, 4, -58).asSequence()

        // When
        val (listMin, listMax) = list.minAndMaxOrNull() ?: fail()
        val (seqMin, seqMax) = seq.minAndMaxOrNull() ?: fail()

        // then
        assertEquals(-98, listMin)
        assertEquals(978, listMax)
        assertEquals(-98, seqMin)
        assertEquals(978, seqMax)
    }
}
