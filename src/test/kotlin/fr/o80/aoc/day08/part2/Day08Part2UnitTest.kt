package fr.o80.aoc.day08.part2

import fr.o80.aoc.day08.Day08
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day08Part2UnitTest {

    private val day = Day08()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, expectedOutput: Int) {
        // when
        val result = day.part2(day.parse2(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d8_p2_1, result_d8_p2_1),
                Arguments.of(input_d8_p2_2, result_d8_p2_2),
                Arguments.of(input_d8_p2_3, result_d8_p2_3),
                Arguments.of(exercise_d8_p2, -1),
            )
        }

    }

}
