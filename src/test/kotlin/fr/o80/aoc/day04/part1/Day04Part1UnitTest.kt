package fr.o80.aoc.day04.part1

import fr.o80.aoc.day04.Day04
import fr.o80.aoc.day04.Day04Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day04Part1UnitTest {

    private val day = Day04()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Int) {
        // when
        val validPassports = day.simpleValidityCount(Day04Parser.parse(input))

        // then
        assertEquals(expectedOutput, validPassports)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d4_p1_1, result_d4_p1_1),
                Arguments.of(exercise_d4_p1, 170)
            )
        }

    }

}