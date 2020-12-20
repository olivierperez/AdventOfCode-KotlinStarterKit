package fr.o80.aoc.day20.part1

import fr.o80.aoc.day20.Day20
import fr.o80.aoc.day20.exercise_d20
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day20Part1UnitTest {

    private val day = Day20()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(input: String, expectedOutput: Long) {
        // when
        val result = day.part1(day.parse1(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d20_p1_1, result_d20_p1_1),
                Arguments.of(exercise_d20, 8425574315321L),
            )
        }

    }

}
