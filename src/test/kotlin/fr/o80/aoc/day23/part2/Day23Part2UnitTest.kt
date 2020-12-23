package fr.o80.aoc.day23.part2

import fr.o80.aoc.day23.Day23
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day23Part2UnitTest {

    private val day = Day23()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(moves: Int, input: String, expectedOutput: Long) {
        // when
        val result = day.part2(moves, day.parse(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(10_000_000, "389125467", 149245887792L),
                Arguments.of(10_000_000, "186524973", "111080192688"),
            )
        }

    }

}
