package fr.o80.aoc.day05.part1

import fr.o80.aoc.day05.Day05
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day05Part1UnitTest {

    private val day = Day05()

    @ParameterizedTest
    @MethodSource("provideHighestId")
    fun computeHighestSeatId(input: String, expectedOutput: Int) {
        // when
        val seatId = day.highestSeatId(day.parseToSeatId(input))

        // then
        assertEquals(expectedOutput, seatId)
    }

    companion object {

        @JvmStatic
        fun provideHighestId(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d5_p1_1 + "\n" + input_d5_p1_2 + "\n" + input_d5_p1_3, result_d5_p1_3_id),
                Arguments.of(exercise_d5_p1, 848),
            )
        }

    }

}