package fr.o80.aoc.kit.astar

import fr.o80.aoc.kit.Vector2i
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import kotlin.math.abs

internal class AStarCalculatorTest {

    private val calculator = AStarCalculator()

    private val start = Vector2i(0,0)
    private val end = Vector2i(1, 4)
    private val nodes = listOf(
        Vector2i(0,0),
        Vector2i(0, 1),
        Vector2i(0, 2),
        Vector2i(0, 3),
        Vector2i(0, 4),
        Vector2i(1, 4)
    )

    private val astarInformer = object : AstarInformer<Vector2i> {
        override fun isEnd(node: Vector2i): Boolean = node == end
        override fun estimatedCostToTheEnd(node: Vector2i): Float {
            return (abs(node.x - end.x)+ abs(node.y - end.y)).toFloat()
        }

        override fun neighborsOf(currentNode: Vector2i): Iterable<Vector2i> {
            return when (currentNode) {
                start -> listOf(nodes[start.y + 1])
                end -> listOf(nodes[end.y - 1])
                else -> listOf(nodes[currentNode.y - 1], nodes[currentNode.y + 1])
            }
        }

        override fun costBetween(from: Vector2i, to: Vector2i): Float {
            return (abs(from.x - to.x) + abs(from.y-to.y))
                .takeIf { it == 1 }
                ?.toFloat()
                ?: Float.MAX_VALUE
        }
    }

    @Test
    @DisplayName("AStar Calculator should find the straightforward path")
    fun shouldFindStraightforwardPath() {
        // When
        val path = calculator.getShortestPathOf(start, astarInformer)

        // Then
        path ?: fail("Path should be calculated, but it wasn't")

        with (path.first()) {
            assertEquals(start, this)
            assertEquals(5f, astarInformer.estimatedCostToTheEnd(this))
        }
        with (path.last()) {
            assertEquals(end, this)
            assertEquals(0f, astarInformer.estimatedCostToTheEnd(this))
        }

        assertEquals(nodes[0], path[0])
        assertEquals(nodes[1], path[1])
        assertEquals(nodes[2], path[2])
        assertEquals(nodes[3], path[3])
        assertEquals(nodes[4], path[4])
        assertEquals(nodes[5], path[5])
    }

}
