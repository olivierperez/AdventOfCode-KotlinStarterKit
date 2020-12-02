package fr.o80.aoc.kit.astar

import java.util.*

class AStarCalculator {

    fun <N> getShortestPathOf(
        start: N,
        nodeInformer: AstarInformer<N>
    ): List<N>? {
        val done: MutableList<AStarNode<N>> = mutableListOf()
        val todo: PriorityQueue<AStarNode<N>> = PriorityQueue(AStarNodeComparator(nodeInformer))

        val startNode = AStarNode(start, 0f, null)
        todo.offer(startNode)

        while (todo.isNotEmpty()) {
            val currentNode = todo.poll()
            if (nodeInformer.isEnd(currentNode.item)) {
                return buildPath(currentNode)
            }

            for (neighbor in nodeInformer.neighborsOf(currentNode.item)) {
                if (neighbor !in done) {
                    val neighborNode = todo.getWrapperOf(neighbor)

                    if (neighborNode != null) {
                        val costToNext = nodeInformer.costBetween(currentNode.item, neighbor)
                        neighborNode.costFromStart = currentNode.costFromStart + costToNext
                        neighborNode.previous = currentNode
                        todo.offer(neighborNode)
                    } else {
                        val costToNext = nodeInformer.costBetween(currentNode.item, neighbor)
                        val nextNode = AStarNode(
                            item = neighbor,
                            costFromStart = currentNode.costFromStart + costToNext,
                            previous = currentNode
                        )
                        todo.offer(nextNode)
                    }
                }
            }

            done.add(currentNode)
        }

        return null
    }

    private fun <N> buildPath(lastNode: AStarNode<N>): List<N> {
        val path = mutableListOf<N>()

        var node: AStarNode<N>? = lastNode
        while (node != null) {
            path.add(node.item)
            node = node.previous
        }

        return path.reversed()
    }
}

private operator fun <N> Iterable<AStarNode<N>>.contains(node: N): Boolean {
    return this.any { it.item == node }
}

private fun <N> Iterable<AStarNode<N>>.getWrapperOf(node: N): AStarNode<N>? {
    return this.firstOrNull { it.item == node }
}