package fr.o80.aoc.day07.part1

import fr.o80.aoc.day07.Day07
import fr.o80.aoc.day07.Day07Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day07Part1UnitTest {

    private val day = Day07()

    @ParameterizedTest(name = "Should count the bags that should contain Shiny gold one")
    @MethodSource("provide")
    fun bagsContainingShinyGold(input: String, expectedOutput: Int) {
        // when
        val bagsContainingShinyGold = day.containsShinyGold(Day07Parser.parse(input)).count()

        // then
        assertEquals(expectedOutput, bagsContainingShinyGold)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d7_p1_1, result_d7_p1_1),
                Arguments.of(exercise_d7_p1, 124),
            )
        }

    }

}