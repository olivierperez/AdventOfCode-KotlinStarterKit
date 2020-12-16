package fr.o80.aoc.day16.part1

import fr.o80.aoc.day16.Day16
import fr.o80.aoc.day16.Day16Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day16Part1UnitTest {

    private val day = Day16()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(rules: String, myTicket: String, nearbyTickets: String, expectedOutput: Long) {
        // when
        val result = day.part1(Day16Parser.parse(rules, myTicket, nearbyTickets))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    input_d16_p1_1_rules,
                    input_d16_p1_1_myticket,
                    input_d16_p1_1_nearby,
                    result_d16_p1_1
                ),
                Arguments.of(
                    exercise_d16_rules,
                    exercise_d16_myticket,
                    exercise_d16_nearby,
                    20048
                ),
            )
        }

    }

}
