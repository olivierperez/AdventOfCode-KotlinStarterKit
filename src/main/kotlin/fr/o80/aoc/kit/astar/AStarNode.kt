package fr.o80.aoc.kit.astar

interface AStarNode {
    val isEnd: Boolean
    var costFromStart: Float
    val estimatedTotalCost: Float
    var previous: AStarNode?
}
