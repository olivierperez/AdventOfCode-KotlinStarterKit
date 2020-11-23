package fr.o80.aoc.kit.astar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class AStarNodeComparatorTest {

    @Test
    @DisplayName("Compare only 2 A* nodes")
    fun shouldCompare() {
        // Given
        val worst = ComparatorAStarNode(1f, 50f)
        val best = ComparatorAStarNode(2f, 20f)

        // When
        val worstIsWorst = AStarNodeComparator<ComparatorAStarNode>().compare(worst, best) > 0

        // then
        assertTrue(worstIsWorst)
    }

    @Test
    @DisplayName("Sort list of 2 A* nodes")
    fun shouldSort() {
        // Given
        val nodes = listOf(
            ComparatorAStarNode(1f, 50f),
            ComparatorAStarNode(2f, 20f),
            ComparatorAStarNode(3f, 24f)
        )

        // When
        val sorted = nodes.sortedWith(AStarNodeComparator())

        // then
        assertEquals(2f, sorted[0].costFromStart)
        assertEquals(3f, sorted[1].costFromStart)
        assertEquals(1f, sorted[2].costFromStart)
    }

}

private class ComparatorAStarNode(
    override var costFromStart: Float = -1f,
    override val estimatedTotalCost: Float = -1f,
    override val isEnd: Boolean = false,
    override var previous: AStarNode? = null
) : AStarNode