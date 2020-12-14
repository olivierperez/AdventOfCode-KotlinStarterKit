package fr.o80.aoc.day14.part2

import fr.o80.aoc.day14.Day14
import fr.o80.aoc.day14.Day14Parser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day14Part2UnitTest {

    private val day = Day14()

    @Test
    @DisplayName("Description")
    fun shouldGenerateComplements() {
        // Given
        val addrMask = "000000000000000000000000000000X1001X"

        // When
        val complements = day.generateAddrComplements(addrMask)

        // then
        assertEquals(0b010010, complements[0])
        assertEquals(0b010011, complements[1])
        assertEquals(0b110010, complements[2])
        assertEquals(0b110011, complements[3])
    }

    @ParameterizedTest
    @MethodSource("provide")
    fun computePart2(input: String, expectedOutput: Long) {
        // when
        val result = day.applyMasksOnAddresses(Day14Parser.parse(input))

        // then
        assertEquals(expectedOutput, result)
    }

    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(input_d14_p2_1, result_d14_p2_1),
                Arguments.of(exercise_d14_p2, 4215284199669L),
            )
        }

    }

}
