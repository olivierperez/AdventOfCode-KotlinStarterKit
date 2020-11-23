package fr.o80.aoc.kit.astar

interface AStarGraph<N : AStarNode> {
    val start: N
    val end: N
    fun neighborsOf(currentNode: N): Iterable<N>
}
