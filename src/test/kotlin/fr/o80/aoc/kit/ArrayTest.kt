package fr.o80.aoc.kit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Tests about Arrays")
internal class ArrayTest {

    @Test
    @DisplayName("Swap indexes in IntArray")
    fun swapIndexesOfIntArray() {
        // given
        val array = intArrayOf(1,2,3,4,5)

        // when
        array.swap(0,2)
        array.swap(4,1)

        // then
        val expected = intArrayOf(3, 5, 1, 4, 2)
        assertTrue(expected.contentEquals(array), "The expected was ${expected.show()}, but was ${array.show()}")
    }

    @Test
    @DisplayName("Swap indexes in Array of <T>")
    fun swapIndexesOfArrayOfT() {
        // given
        val array = arrayOf("1", "2", "3", "4")

        // when
        array.swap(0,2)
        array.swap(3,1)

        // then
        val expected = arrayOf("3", "4", "1", "2")
        assertTrue(expected.contentEquals(array), "The expected was ${expected.show()}, but was ${array.show()}")
    }
}
