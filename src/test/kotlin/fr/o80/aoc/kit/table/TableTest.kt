package fr.o80.aoc.kit.table

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class TableTest {

    @Test
    @DisplayName("Compute clockwise rotation")
    fun shouldRotate() {
        // Given
        // A B C
        // D E F
        val table = Table<Char>(3, 2).apply {
            this[0, 0] = 'A'
            this[1, 0] = 'B'
            this[2, 0] = 'C'
            this[0, 1] = 'D'
            this[1, 1] = 'E'
            this[2, 1] = 'F'
        }

        // When
        val rotated = table.clockwiseRotated()

        // Then
        // D A
        // E B
        // F C
        assertEquals('D', rotated[0, 0])
        assertEquals('A', rotated[1, 0])
        assertEquals('E', rotated[0, 1])
        assertEquals('B', rotated[1, 1])
        assertEquals('F', rotated[0, 2])
        assertEquals('C', rotated[1, 2])
    }

    @Test
    @DisplayName("Compute horizontal flip")
    fun shouldHorizontalFlip() {
        // Given
        // A B C
        // D E F
        val table = Table<Char>(3, 2).apply {
            this[0, 0] = 'A'
            this[1, 0] = 'B'
            this[2, 0] = 'C'
            this[0, 1] = 'D'
            this[1, 1] = 'E'
            this[2, 1] = 'F'
        }

        // When
        val flipped = table.horizontalFlip()

        // Then
        // C B A
        // F E D
        assertEquals('C', flipped[0, 0])
        assertEquals('B', flipped[1, 0])
        assertEquals('A', flipped[2, 0])
        assertEquals('F', flipped[0, 1])
        assertEquals('E', flipped[1, 1])
        assertEquals('D', flipped[2, 1])
    }

}
