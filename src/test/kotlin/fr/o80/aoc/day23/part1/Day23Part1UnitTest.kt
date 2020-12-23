package fr.o80.aoc.day23.part1

import fr.o80.aoc.day23.Day23
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day23Part1UnitTest {

    private val day = Day23()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(moves: Int, input: String, expectedOutput: String) {
        // when
        val result = day.part1(moves, day.parse(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(10, "389125467", "92658374"),
                Arguments.of(100, "389125467", "67384529"),
                Arguments.of(100, "186524973", "45983627"),
            )
        }

    }

}
