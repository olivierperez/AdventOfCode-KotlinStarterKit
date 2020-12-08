package fr.o80.aoc.day08

sealed class Operation {
    abstract fun apply(state: Day08State, idx: Int): Day08State
}

data class Acc(val value: Int) : Operation() {
    override fun apply(state: Day08State, idx: Int): Day08State =
        state.copy(
            acc = state.acc + value,
            nextIdx = state.nextIdx + 1,
            visited = state.visited + Visited(idx, state.acc)
        )
}

data class Jump(val value: Int) : Operation() {
    override fun apply(state: Day08State, idx: Int): Day08State =
        state.copy(
            nextIdx = state.nextIdx + value,
            visited = state.visited + Visited(idx, state.acc)
        )
}

data class Noop(val value: Int) : Operation() {
    override fun apply(state: Day08State, idx: Int): Day08State =
        state.copy(
            nextIdx = state.nextIdx + 1,
            visited = state.visited + Visited(idx, state.acc)
        )
}
