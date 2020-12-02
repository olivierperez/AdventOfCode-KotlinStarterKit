package fr.o80.aoc.kit.astar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AStarNodeComparatorTest {

    // |0-->24->30-->60|
    private val comparator = AStarNodeComparator(object : AstarInformer<Int> {
        override fun isEnd(node: Int): Boolean = false
        override fun neighborsOf(currentNode: Int): Iterable<Int> = emptyList()
        override fun costBetween(from: Int, to: Int): Float = 0f
        override fun estimatedCostToTheEnd(node: Int): Float {
            return node.toFloat()
        }
    })

    @Test
    @DisplayName("Compare only 2 A* nodes")
    fun shouldCompare() {
        // Given
        val worst = AStarNode(50, 1f, null)
        val best = AStarNode(20, 2f, null)

        // When
        val worstIsWorst = comparator.compare(worst, best) > 0

        // then
        assertTrue(worstIsWorst)
    }

    @Test
    @DisplayName("Sort list of 2 A* nodes")
    fun shouldSort() {
        // Given
        val nodes = listOf(
            AStarNode(50, 1f, null),
            AStarNode(20, 2f, null),
            AStarNode(24, 3f, null)
        )

        // When
        val sorted = nodes.sortedWith(comparator)

        // then
        assertEquals(2f, sorted[0].costFromStart)
        assertEquals(3f, sorted[1].costFromStart)
        assertEquals(1f, sorted[2].costFromStart)
    }

}
