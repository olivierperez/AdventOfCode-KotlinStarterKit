package fr.o80.aoc.day18.part1

import fr.o80.aoc.day18.Day18
import fr.o80.aoc.day18.exercise_d18
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day18Part1UnitTest {

    private val day = Day18()

    @ParameterizedTest(name = "Compute {0}")
    @MethodSource("provide")
    fun computePart1(input: String, expectedOutput: Long) {
        // when
        val result = day.part1(day.parse(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 2 * 3 + 4 * 5 + 6", 71),
                Arguments.of("2 * 3 + ( 4 * 5 )", 26),
                Arguments.of("5 + ( 8 * 3 + 9 + 3 * 4 * 3 )", 437),
                Arguments.of("5 * 9 * ( 7 * 3 * 3 + 9 * 3 + ( 8 + 6 * 4 ) )", 12240),
                Arguments.of("( ( 2 + 4 * 9 ) * ( 6 + 9 * 8 + 6 ) + 6 ) + 2 + 4 * 2", 13632),
                Arguments.of("1 + ( 2 * 3 ) + ( 4 * ( 5 + 6 ) )", 51),
                Arguments.of(exercise_d18, 280014646144L),
            )
        }

    }

}
