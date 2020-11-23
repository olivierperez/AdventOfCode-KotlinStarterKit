package fr.o80.aoc.kit.astar

import fr.o80.aoc.kit.show
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.math.abs

internal class AStarCalculatorTest {

    private val calculator = AStarCalculator()
    private val start = CalculatorAStarNode(0, 0)
    private val end = CalculatorAStarNode(1, 4)

    @Test
    @DisplayName("AStar Calculator should find the straightforward path")
    fun shouldFindStraightforwardPath() {
        // Given
        val graph = AStarGraphTestImpl(
            listOf(
                start,
                CalculatorAStarNode(0, 1),
                CalculatorAStarNode(0, 2),
                CalculatorAStarNode(0, 3),
                CalculatorAStarNode(0, 4),
                end
            ), start, end)

        // When
        val lastNode = calculator.updateShortPathOf(graph)

        // Then
        assertNotNull(lastNode)

        with (graph.start) {
            assertEquals(0f, costFromStart)
            assertEquals(5f, estimatedTotalCost)
        }
        with (graph.end) {
            assertEquals(5f, costFromStart)
            assertEquals(5f, estimatedTotalCost)
        }

        assertEquals(graph.nodes[4], graph.nodes[5].previous)
        assertEquals(graph.nodes[3], graph.nodes[4].previous)
        assertEquals(graph.nodes[2], graph.nodes[3].previous)
        assertEquals(graph.nodes[1], graph.nodes[2].previous)
        assertEquals(graph.nodes[0], graph.nodes[1].previous)
    }

    private inner class CalculatorAStarNode(
        val x: Int,
        val y: Int,
        override var costFromStart: Float = -1f,
        override val isEnd: Boolean = false,
        override var previous: AStarNode? = null
    ) : AStarNode {
        override val estimatedTotalCost: Float
            get() = costFromStart + abs(end.y - this.y) + abs(end.x - this.x)

        override fun toString(): String {
            return "{x:$x, y:$y, costFromStart:$costFromStart, estimatedTotalCost:$estimatedTotalCost}"
        }

    }

    private inner class AStarGraphTestImpl(
        val nodes: List<CalculatorAStarNode>,
        override val start: CalculatorAStarNode,
        override val end: CalculatorAStarNode
    ) : AStarGraph<CalculatorAStarNode> {

        override fun neighborsOf(currentNode: CalculatorAStarNode): Iterable<CalculatorAStarNode> {
            return when (currentNode) {
                start -> listOf(nodes[start.y + 1])
                end -> listOf(nodes[end.y - 1])
                else -> listOf(nodes[currentNode.y - 1], nodes[currentNode.y + 1])
            }
        }

    }
}
