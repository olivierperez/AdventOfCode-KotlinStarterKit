package fr.o80.aoc.day07.part2

import fr.o80.aoc.day07.Day07
import fr.o80.aoc.day07.Day07Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day07Part2UnitTest {

    private val day = Day07()

    @ParameterizedTest(name = "Should count how many bags are within Shiny gold one")
    @MethodSource("provide")
    fun countBagsInShinyGoldBag(input: String, expectedOutput: Int) {
        // when
        val bagsCount = day.countBagsInShinyGoldBag(Day07Parser.parse(input))

        // then
        assertEquals(expectedOutput, bagsCount)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d7_p2_1, result_d7_p2_1),
                Arguments.of(exercise_d7_p2, 34862),
            )
        }

    }

}