package fr.o80.aoc.kit.astar

class AStarNode<N>(
    val item: N,
    var costFromStart: Float,
    var previous: AStarNode<N>?
)
