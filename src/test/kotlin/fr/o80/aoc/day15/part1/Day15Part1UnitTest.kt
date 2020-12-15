package fr.o80.aoc.day15.part1

import fr.o80.aoc.day15.Day15
import fr.o80.aoc.day15.Day15Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day15Part1UnitTest {

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(input: String, expectedOutput: Int) {
        // when
        val day = Day15(Day15Parser.parse(input))
        val result = day.findThe2020th()

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d15_p1_1, result_d15_p1_1),
                Arguments.of(exercise_d15_p1, 257),
            )
        }

    }

}
