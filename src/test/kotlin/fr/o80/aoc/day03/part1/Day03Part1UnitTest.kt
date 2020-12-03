package fr.o80.aoc.day03.part1

import fr.o80.aoc.day03.Day03
import fr.o80.aoc.day03.Day03Parser
import fr.o80.aoc.day03.countTrees
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day03Part1UnitTest {

    private val day = Day03()

    @ParameterizedTest
    @MethodSource("provide")
    fun computeRequiredFull(input: String, expectedOutput: Int) {
        // when
        val result = day.computePart1(Day03Parser.parse(input)).countTrees()

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d3_p1_1, result_d3_p1_1),
                Arguments.of(exercise_d3_p1, 187)
            )
        }

    }

}