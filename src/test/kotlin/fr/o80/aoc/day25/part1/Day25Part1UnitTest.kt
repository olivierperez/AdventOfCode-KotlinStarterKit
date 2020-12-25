package fr.o80.aoc.day25.part1

import fr.o80.aoc.day25.Day25
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day25Part1UnitTest {

    private val day = Day25()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(cardPubKey: Long, doorPubKey: Long, expectedOutput: Long) {
        // when
        val result = day.part1(cardPubKey, doorPubKey)

        // then
        assertEquals(expectedOutput, result)
    }

    @Test
    @DisplayName("Handshake mechanism")
    fun testHandshakeMechanism() {
        assertEquals(14897079L, day.handshake(17807724L, 8L))
        assertEquals(14897079L, day.handshake(5764801L, 11L))
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(17807724L, 5764801L, 14897079L),
                Arguments.of(19774466L, 7290641L, 19414467L),
            )
        }

    }

}
