package fr.o80.aoc.day21.part2

import fr.o80.aoc.day21.Day21
import fr.o80.aoc.day21.Day21Parser
import fr.o80.aoc.day21.exercise_d21
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day21Part2UnitTest {

    private val day = Day21()

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, expectedOutput: String) {
        // when
        val result = day.part2(Day21Parser.parse(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d21_p2_1, result_d21_p2_1),
                Arguments.of(exercise_d21, "xlxknk,cskbmx,cjdmk,bmhn,jrmr,tzxcmr,fmgxh,fxzh"),
            )
        }

    }

}
