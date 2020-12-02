package fr.o80.aoc.day02.part2

import fr.o80.aoc.day02.Day02
import fr.o80.aoc.day02.Day02Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day02Part2UnitTest {

    private val day = Day02()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Int) {
        // when
        val validPasswordsCount = day.part2(Day02Parser.parse(input))

        // then
        assertEquals(expectedOutput, validPasswordsCount)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d2_p2_1, result_d2_p2_1),
                Arguments.of(exercise_d2_p2, 354)
            )
        }

    }

}