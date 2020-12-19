package fr.o80.aoc.day18.part2

import fr.o80.aoc.day18.Day18
import fr.o80.aoc.day18.exercise_d18
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day18Part2UnitTest {

    private val day = Day18()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, expectedOutput: Long) {
        // when
        val result = day.part2(day.parse(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1 + 2 * 3 + 4 * 5 + 6", 231),
                Arguments.of("1 + ( 2 * 3 ) + ( 4 * ( 5 + 6 ) )", 51),
                Arguments.of("2 * 3 + ( 4 * 5 )", 46),
                Arguments.of("5 + ( 8 * 3 + 9 + 3 * 4 * 3 )", 1445),
                Arguments.of("5 * 9 * ( 7 * 3 * 3 + 9 * 3 + ( 8 + 6 * 4 ) )", 669060),
                Arguments.of("( ( 2 + 4 * 9 ) * ( 6 + 9 * 8 + 6 ) + 6 ) + 2 + 4 * 2", 23340),
                Arguments.of(exercise_d18, 9966990988262),
            )
        }

    }

}
