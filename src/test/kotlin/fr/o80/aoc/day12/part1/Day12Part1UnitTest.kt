package fr.o80.aoc.day12.part1

import fr.o80.aoc.day12.Day12Part1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day12Part1UnitTest {

    private val day = Day12Part1()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(input: String, expectedOutput: Int) {
        // when
        val result = day.part1(day.parse1(input))

        // then
        assertEquals(expectedOutput, result)
    }

    @Test
    fun check() {
        val distance = day.part1(day.parse1(exercise_d12_p1))
        assertTrue(distance > 1287)
        assertTrue(distance > 1551)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d12_p1_1, result_d12_p1_1),
                Arguments.of(input_d12_p1_2, result_d12_p1_2),
                Arguments.of(exercise_d12_p1, 1589),
            )
        }

    }

}
