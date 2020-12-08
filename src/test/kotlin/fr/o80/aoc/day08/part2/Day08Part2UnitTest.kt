package fr.o80.aoc.day08.part2

import fr.o80.aoc.day08.Day08
import fr.o80.aoc.day08.Day08Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day08Part2UnitTest {

    private val day = Day08()

    @ParameterizedTest
    @MethodSource("provide")
    fun shouldFixInfiniteLoop(input: String, expectedOutput: Int) {
        // when
        val fixedAccumulator = day.fixInfiniteLoop(Day08Parser.parse(input))

        // then
        assertEquals(expectedOutput, fixedAccumulator)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d8_p2_1, result_d8_p2_1),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
                Arguments.of(exercise_d8_p2, 1358),
            )
        }

    }

}