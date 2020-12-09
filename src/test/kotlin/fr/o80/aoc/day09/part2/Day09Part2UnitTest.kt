package fr.o80.aoc.day09.part2

import fr.o80.aoc.day09.Day09
import fr.o80.aoc.day09.Day09Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day09Part2UnitTest {

    private val day = Day09()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, preamble: Long, expectedOutput: Long) {
        // when
        val sumOfMinMaxFromRange = day.findRangeToSumToThePart1(preamble, Day09Parser.parse(input))

        // then
        assertEquals(expectedOutput, sumOfMinMaxFromRange)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d9_p2_1, input_d9_p2_1_preamble, result_d9_p2_1),
                Arguments.of(exercise_d9_p2, 25L, 76096372L)
            )
        }
    }

}