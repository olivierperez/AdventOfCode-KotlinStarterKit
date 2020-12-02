package fr.o80.aoc.kit.astar

import java.util.Comparator

class AStarNodeComparator<N, NW : AStarNode<N>>(
    private val nodeInformer: AstarInformer<N>
) : Comparator<NW> {
    override fun compare(a: NW, b: NW): Int {
        val totalEstimatedCostOfA = a.costFromStart + nodeInformer.estimatedCostToTheEnd(a.item)
        val totalEstimatedCostOfB = b.costFromStart + nodeInformer.estimatedCostToTheEnd(b.item)
        return totalEstimatedCostOfA.compareTo(totalEstimatedCostOfB)
    }
}
