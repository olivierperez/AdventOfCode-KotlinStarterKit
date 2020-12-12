package fr.o80.aoc.day11.part2

import fr.o80.aoc.day11.Day11
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day11Part2UnitTest {

    private val day = Day11()

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
                Arguments.of(input_d11_p2_1, result_d11_p2_1),
                Arguments.of(exercise_d11_p2, 2068),
            )
        }

    }

}
