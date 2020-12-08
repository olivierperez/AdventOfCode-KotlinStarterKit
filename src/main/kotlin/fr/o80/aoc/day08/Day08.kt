package fr.o80.aoc.day08

class Day08 {

    fun findInfiniteLoop(operations: List<Operation>): Int {
        val initialState = Day08State(0, 0, mutableListOf(), false)
        val result = compute(operations, initialState, null)
        return result.acc
    }

    fun fixInfiniteLoop(operations: List<Operation>): Int {
        val initialState = Day08State(0, 0, listOf(), false)
        val failedState = compute(operations, initialState, null)

        val firstValidMutant = failedState.visited
            .asSequence()
            .filterNot { operations[it.idx] is Acc }
            .map { operationToSwitch ->
                val mutant: List<Operation> = switchOperation(operations, operationToSwitch.idx)
                val memorizedAcc = failedState.visited.accAtIndex(operationToSwitch.idx)
                val memorizedInitialState = Day08State(memorizedAcc, operationToSwitch.idx, listOf(), false)
                compute(mutant, memorizedInitialState, failedState.visited)
            }
            .firstOrNull { it.success }

        return firstValidMutant?.acc
            ?: throw IllegalStateException("no mutant found")
    }

    private tailrec fun compute(
        operations: List<Operation>,
        state: Day08State,
        visitedWhenFailed: List<Visited>?
    ): Day08State {
        if (state.nextIdx in state.visited) {
            return state.copy(success = false)
        }
        if (state.nextIdx > operations.lastIndex) {
            return state.copy(success = true)
        }

        val op = operations[state.nextIdx]
        val newState = op.apply(state, state.nextIdx)

        if (visitedWhenFailed != null && newState.nextIdx in visitedWhenFailed) {
            return state.copy(success = false)
        }

        return compute(operations, newState, visitedWhenFailed)
    }

    private fun switchOperation(operations: List<Operation>, id: Int): List<Operation> =
        operations.mapIndexed { index, operation ->
            if (index == id) {
                when (operation) {
                    is Jump -> Noop(operation.value)
                    is Noop -> Jump(operation.value)
                    else -> throw IllegalArgumentException("Tu essayes de changer un ${operation.javaClass}")
                }
            } else {
                operation
            }
        }

}

private fun List<Visited>.accAtIndex(idx: Int): Int {
    return this.first { it.idx == idx }.acc
}

operator fun List<Visited>.contains(idx: Int) = this.any { it.idx == idx }

data class Day08State(val acc: Int, val nextIdx: Int, val visited: List<Visited>, val success: Boolean)

data class Visited(val idx: Int, val acc: Int)
