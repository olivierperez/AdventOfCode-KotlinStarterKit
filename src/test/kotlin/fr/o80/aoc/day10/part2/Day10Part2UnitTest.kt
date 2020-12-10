package fr.o80.aoc.day10.part2

import fr.o80.aoc.day10.Day10
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day10Part2UnitTest {

    private val day = Day10()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Long) {
        // when
        val computedFuel = day.part2(day.parse2(input))

        // then
        assertEquals(expectedOutput, computedFuel)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d10_p2_1, result_d10_p2_1),
                Arguments.of(input_d10_p2_2, result_d10_p2_2),
                Arguments.of(input_d10_p2_3, result_d10_p2_3),
                Arguments.of(input_d10_p2_4, result_d10_p2_4),
                Arguments.of(input_d10_p2_5, result_d10_p2_5),
                Arguments.of(exercise_d10_p2, 42313823813632)
            )
        }

    }

}