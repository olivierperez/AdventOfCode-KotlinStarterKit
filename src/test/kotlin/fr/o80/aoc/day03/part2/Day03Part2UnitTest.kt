package fr.o80.aoc.day03.part2

import fr.o80.aoc.day03.Day03
import fr.o80.aoc.day03.Day03Parser
import fr.o80.aoc.day03.multiplyTrees
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day03Part2UnitTest {

    private val day = Day03()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Long) {
        // when
        val result = day.part2(Day03Parser.parse(input)).multiplyTrees()

        // then
        assertEquals(expectedOutput, result)
    }

    @Test
    fun checks() {
        // when
        val validPasswordsCount = day.part2(Day03Parser.parse(exercise_d3_p2)).multiplyTrees()

        // then
        assertTrue(validPasswordsCount > 428316104L, "Result must be bigger than 428316104, but was $validPasswordsCount")
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d3_p2_1, result_d3_p2_1),
                Arguments.of(exercise_d3_p2, 4723283400L)
            )
        }

    }

}