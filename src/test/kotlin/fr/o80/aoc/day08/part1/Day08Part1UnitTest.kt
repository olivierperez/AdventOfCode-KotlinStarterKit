package fr.o80.aoc.day08.part1

import fr.o80.aoc.day08.Day08
import fr.o80.aoc.day08.Day08Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day08Part1UnitTest {

    private val day = Day08()

    @ParameterizedTest
    @MethodSource("provide")
    fun shouldfindInfiniteLoop(input: String, expectedOutput: Int) {
        // when
        val accumulatorBeforeInfiniteLoop = day.findInfiniteLoop(Day08Parser.parse(input))

        // then
        assertEquals(expectedOutput, accumulatorBeforeInfiniteLoop)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d8_p1_1, result_d8_p1_1),
                Arguments.of(exercise_d8_p1, 1337)
            )
        }

    }

}