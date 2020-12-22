package fr.o80.aoc.day22.part1

import fr.o80.aoc.day22.Day22
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day22Part1UnitTest {

    private val day = Day22()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart1(player1: String, player2: String, expectedOutput: Int) {
        // when
        val result = day.part1(day.parse1(player1, player2))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d22_p1_1_1, input_d22_p1_1_2, result_d22_p1_1),
                Arguments.of(exercise_d22_p1_1, exercise_d22_p1_2, 31809),
            )
        }

    }

}
