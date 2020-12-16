package fr.o80.aoc.day16.part2

import fr.o80.aoc.day16.Day16
import fr.o80.aoc.day16.Day16Parser
import fr.o80.aoc.day16.part1.exercise_d16_myticket
import fr.o80.aoc.day16.part1.exercise_d16_nearby
import fr.o80.aoc.day16.part1.exercise_d16_rules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day16Part2UnitTest {

    private val day = Day16()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(rules: String, myTicket: String, nearbyTickets: String, expectedOutput: Long) {
        // when
        val result = day.part2(Day16Parser.parse(rules, myTicket, nearbyTickets))

        // then
        assertEquals(expectedOutput, result)
    }

    @Test
    @DisplayName("Description")
    fun shouldTest() {
        // When
        val result = day.part2(Day16Parser.parse(exercise_d16_rules, exercise_d16_myticket, exercise_d16_nearby))

        // then
        assertTrue(result > 1903164257)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    input_d16_p2_1_rules,
                    input_d16_p2_1_myticket,
                    input_d16_p2_1_nearby,
                    result_d16_p2_1
                ),
                Arguments.of(
                    exercise_d16_rules,
                    exercise_d16_myticket,
                    exercise_d16_nearby,
                    4810284647569
                ),
            )
        }

    }

}
