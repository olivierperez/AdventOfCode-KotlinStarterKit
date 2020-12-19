package fr.o80.aoc.day19.part2

import fr.o80.aoc.day19.Day19
import fr.o80.aoc.day19.Day19Parser
import fr.o80.aoc.day19.part1.exercise_d19_p1_messages
import fr.o80.aoc.day19.part1.exercise_d19_p1_rules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day19Part2UnitTest {

    private val day = Day19()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(rules: String, messages: String, expectedOutput: Int) {
        // when
        val result = day.part2(Day19Parser.parse(rules, messages))

        // then
        assertEquals(expectedOutput, result)
    }

    @Test
    @DisplayName("Description")
    fun shouldTest() {
        assertTrue(day.part2(Day19Parser.parse(exercise_d19_p1_rules, exercise_d19_p1_messages)) > 147)
        assertTrue(day.part2(Day19Parser.parse(exercise_d19_p1_rules, exercise_d19_p1_messages)) > 221)
        assertTrue(day.part2(Day19Parser.parse(exercise_d19_p1_rules, exercise_d19_p1_messages)) != 277)
        assertTrue(day.part2(Day19Parser.parse(exercise_d19_p1_rules, exercise_d19_p1_messages)) < 318)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d19_p2_1_rules, input_d19_p2_1_messages, result_d19_p2_1),
                Arguments.of(input_d19_p2_2_rules, input_d19_p2_2_messages, result_d19_p2_2),
                Arguments.of(exercise_d19_p1_rules, exercise_d19_p1_messages, 263),
            )
        }

    }

}
