package fr.o80.aoc.kit.astar

import java.util.*

class AStarCalculator {

    fun <N : AStarNode, G : AStarGraph<N>> updateShortPathOf(graph: G): N? {
        val done = mutableListOf<N>()
        val todo = PriorityQueue(AStarNodeComparator<N>())

        with(graph.start) {
            this.costFromStart = 0f
            todo.offer(this)
        }
        while (todo.isNotEmpty()) {
            val currentNode = todo.poll()
            if (currentNode == graph.end) {
                return currentNode
            }

            for (neighbor in graph.neighborsOf(currentNode)) {
                if (neighbor !in done) {
                    if (neighbor !in todo) {
                        neighbor.costFromStart = currentNode.costFromStart + 1
                        neighbor.previous = currentNode
                        todo.offer(neighbor)
                    }
                }
            }

            done.add(currentNode)
        }

        return null
    }
}

class AStarNodeComparator<N : AStarNode> : Comparator<N> {
    override fun compare(a: N, b: N): Int {
        return a.estimatedTotalCost.compareTo(b.estimatedTotalCost)
    }
}
