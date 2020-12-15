package fr.o80.aoc.day15.part2

import fr.o80.aoc.day15.Day15
import fr.o80.aoc.day15.Day15Parser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day15Part2UnitTest {

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, expectedOutput: Int) {
        //Given
        val day = Day15(Day15Parser.parse(input))

        // when
        val result = day.findThe30000000th()

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d15_p2_1, result_d15_p2_1),
                Arguments.of(exercise_d15_p2, 8546398),
            )
        }

    }

}
