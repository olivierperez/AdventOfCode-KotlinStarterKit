package fr.o80.aoc.kit.astar

interface AstarInformer<N> {
    fun isEnd(node: N): Boolean
    fun estimatedCostToTheEnd(node: N): Float
    fun neighborsOf(currentNode: N): Iterable<N>
    fun costBetween(from: N, to: N): Float
}
