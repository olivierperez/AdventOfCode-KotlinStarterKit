package fr.o80.aoc.day19.part1

import fr.o80.aoc.day19.Day19
import fr.o80.aoc.day19.Day19Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day19Part1UnitTest {

    private val day = Day19()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(rules: String, messages: String, expectedOutput: Int) {
        // when
        val result = day.part1(Day19Parser.parse(rules, messages))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d19_p1_1_rules, input_d19_p1_1_messages, result_d19_p1_1),
                Arguments.of(exercise_d19_p1_rules, exercise_d19_p1_messages, 147),
            )
        }

    }

}
