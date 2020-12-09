package fr.o80.aoc.day09.part1

import fr.o80.aoc.day09.Day09
import fr.o80.aoc.day09.Day09Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day09Part1UnitTest {

    private val day = Day09()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(input: String, preamble: Long, expectedOutput: Long) {
        // when
        val number = day.findNumberThatIsNotSumOfPreamble(preamble, Day09Parser.parse(input))

        // then
        assertEquals(expectedOutput, number)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d9_p1_1, input_d9_p1_1_preamble, result_d9_p1_1),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
                Arguments.of(exercise_d9_p1, 25L, 556543474),
            )
        }
    }

}