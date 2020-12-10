package fr.o80.aoc.day10.part1

import fr.o80.aoc.day10.Day10
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day10Part1UnitTest {

    private val day = Day10()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Int) {
        // when
        val computedFuel = day.part1(day.parse1(input))

        // then
        assertEquals(expectedOutput, computedFuel.ones * computedFuel.threes)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d10_p1_1, result_d10_p1_1),
                Arguments.of(input_d10_p1_2, result_d10_p1_2),
                Arguments.of(exercise_d10_p1, 2030)
            )
        }

    }

}