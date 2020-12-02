package fr.o80.aoc.day02.part1

import fr.o80.aoc.day02.Day02
import fr.o80.aoc.day02.Day02Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day02Part1UnitTest {

    private val day = Day02()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Int) {
        // when
        val validPasswordsCount = day.part1(Day02Parser.parse(input))

        // then
        assertEquals(expectedOutput, validPasswordsCount)
    }

    @Test
    fun checks() {
        // when
        val validPasswordsCount = day.part1(Day02Parser.parse(exercise_d2_p1))

        // then
        assertTrue(validPasswordsCount > 366, "Result must be bigger than 366, but was $validPasswordsCount")
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d2_p1_1, result_d2_p1_1),
                Arguments.of(exercise_d2_p1, 614)
            )
        }

    }

}