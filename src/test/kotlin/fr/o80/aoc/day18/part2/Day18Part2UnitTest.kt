package fr.o80.aoc.day18.part2

import fr.o80.aoc.day18.Day18
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day18Part2UnitTest {

    private val day = Day18()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, expectedOutput: Int) {
        // when
        val result = day.part2(day.parse2(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d18_p2_1, result_d18_p2_1),
                Arguments.of(input_d18_p2_2, result_d18_p2_2),
                Arguments.of(input_d18_p2_3, result_d18_p2_3),
                Arguments.of(exercise_d18_p2, -1),
            )
        }

    }

}
