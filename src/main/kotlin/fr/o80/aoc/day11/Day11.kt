package fr.o80.aoc.day11

import fr.o80.aoc.kit.Vector2i
import fr.o80.aoc.kit.table.Table
import fr.o80.aoc.kit.table.TableParser

enum class State {
    OCCUPIED,
    FREE,
    NONE
}

enum class Direction(val x: Int, val y: Int) {
    TL(-1, -1),
    T(0, -1),
    TR(+1, -1),
    L(-1, 0),
    R(+1, 0),
    BL(-1, +1),
    B(0, +1),
    BR(+1, +1)
}

class Day11 {

    private lateinit var computeNewState: (State, Int) -> State

    fun parse1(input: String): Table<State> {
        return TableParser().parse(input) { c ->
            when (c) {
                '#' -> State.OCCUPIED
                'L' -> State.FREE
                else -> State.NONE
            }
        }
    }

    fun part1(input: Table<State>): Int {
        computeNewState = {state: State, neighbors: Int ->
            when {
                state == State.OCCUPIED && neighbors >= 4 -> State.FREE
                state == State.FREE && neighbors == 0 -> State.OCCUPIED
                else -> state
            }
        }
        val near: Table<List<Vector2i>> = precomputeNearTable(input)
        return executeUntilItLoops(input, near)
    }

    fun parse2(input: String): Table<State> {
        return parse1(input)
    }

    fun part2(input: Table<State>): Int {
        computeNewState = {state: State, neighbors: Int ->
            when {
                state == State.OCCUPIED && neighbors >= 5 -> State.FREE
                state == State.FREE && neighbors == 0 -> State.OCCUPIED
                else -> state
            }
        }
        val near: Table<List<Vector2i>> = precomputeVisibilityTable(input)
        return executeUntilItLoops(input, near)
    }

    private fun precomputeVisibilityTable(table: Table<State>): Table<List<Vector2i>> {
        val near = Table<List<Vector2i>>(table.width, table.height)

        table.forEachIndexed { x, y, _ ->
            val neighbors = Direction.values().mapNotNull { direction ->
                findVisiblePosition(table, x,y,direction)
            }
            near[x, y] = neighbors
        }

        return near
    }

    private fun findVisiblePosition(table: Table<State>, x: Int, y: Int, direction: Direction): Vector2i? {
        var vX = x
        var vY = y
        do {
            vX += direction.x
            vY += direction.y

            val state = table.getOrNull(vX, vY)

            if (state == State.OCCUPIED || state == State.FREE) {
                return Vector2i(vX,vY)
            } else if (state == null) {
                return null
            }
        } while (true)
    }

    private fun precomputeNearTable(table: Table<State>): Table<List<Vector2i>> {
        val near = Table<List<Vector2i>>(table.width, table.height)

        table.forEachIndexed { x, y, _ ->
            val neighbors = Direction.values().map { direction ->
                Vector2i(x + direction.x, y + direction.y)
            }
            near[x, y] = neighbors
        }

        return near
    }

    private fun executeUntilItLoops(table: Table<State>, near: Table<List<Vector2i>>): Int {
        var currentTable = table
        do {
            val (newTable, changed) = oneStep(currentTable, near)
            currentTable = newTable
        } while (changed)

        return currentTable.count { state -> state == State.OCCUPIED }
    }

    private fun oneStep(table: Table<State>, near: Table<List<Vector2i>>): Pair<Table<State>, Boolean> {
        val newTable = Table<State>(table.width, table.height)

        var changed = false

        for (y in 0 until table.height) {
            for (x in 0 until table.width) {
                val neighbors = countNeighbors(table, near[x, y]!!)
                val previousState = table[x, y]!!
                val newState = computeNewState(previousState, neighbors)
                newTable[x, y] = newState

                if (previousState != newState)
                    changed = true
            }
        }

        return Pair(newTable, changed)
    }

    private fun countNeighbors(table: Table<State>, near: List<Vector2i>): Int {
        return near.count { (x, y) ->
            val state = table.getOrNull(x, y)
            state == State.OCCUPIED
        }
    }

}
