package fr.o80.aoc.day24.part2

import fr.o80.aoc.day24.Day24
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day24Part2UnitTest {

    private val day = Day24()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, days: Int, expectedOutput: Int) {
        // when
        val result = day.part2(days, day.parse2(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d24_p2_1, 1, 15),
                Arguments.of(input_d24_p2_1, 2, 12),
                Arguments.of(input_d24_p2_1, 3, 25),
                Arguments.of(input_d24_p2_1, 4, 14),
                Arguments.of(input_d24_p2_1, 100, 2208),
                Arguments.of(exercise_d24_p2, 100, 3700),
            )
        }

    }

}
