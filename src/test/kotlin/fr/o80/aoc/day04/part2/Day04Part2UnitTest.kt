package fr.o80.aoc.day04.part2

import fr.o80.aoc.day04.Day04
import fr.o80.aoc.day04.Day04Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day04Part2UnitTest {

    private val day = Day04()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Int) {
        // when
        val fullyValidPassports = day.complexValidityCount(Day04Parser.parse(input))

        // then
        assertEquals(expectedOutput, fullyValidPassports)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d4_p2_1, result_d4_p2_1),
                Arguments.of(input_d4_p2_2, result_d4_p2_2),
                Arguments.of(exercise_d4_p2, 103)
            )
        }

    }

}