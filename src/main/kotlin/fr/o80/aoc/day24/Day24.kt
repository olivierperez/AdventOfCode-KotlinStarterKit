package fr.o80.aoc.day24

import fr.o80.aoc.kit.Vector2i
import fr.o80.aoc.kit.minAndMaxOrNull
import fr.o80.aoc.kit.table.Table

enum class Direction {
    W, E,
    NW, NE,
    SW, SE
}

data class Instruction(val directions: List<Direction>)

class Day24 {

    fun parse1(input: String): List<Instruction> {
        return input.lines().map { line ->
            val directions = mutableListOf<Direction>()

            var i = 0
            while (i < line.length) {
                when (line[i]) {
                    'e' -> {
                        directions += Direction.E
                        i++
                    }
                    'w' -> {
                        directions += Direction.W
                        i++
                    }
                    'n' -> {
                        directions += (if (line[i + 1] == 'e') Direction.NE else Direction.NW)

                        i += 2
                    }
                    's' -> {
                        directions += (if (line[i + 1] == 'e') Direction.SE else Direction.SW)
                        i += 2
                    }
                }
            }

            Instruction(directions)
        }
    }

    fun part1(instructions: List<Instruction>): Int {
        return initBlackTiles(instructions).size
    }

    private fun initBlackTiles(instructions: List<Instruction>): MutableList<Vector2i> {
        val blackTiles = mutableListOf<Vector2i>()

        instructions.forEach { instruction ->
            val position = instruction.toPosition()
            if (!blackTiles.remove(position)) {
                blackTiles.add(position)
            }
        }
        return blackTiles
    }

    fun parse2(input: String): List<Instruction> {
        return parse1(input)
    }

    fun part2(days: Int, instructions: List<Instruction>): Int {
        val blackTiles: List<Vector2i> = initBlackTiles(instructions)
        val table = toTable(blackTiles)

        return (1..days).fold(table) { previous, _ -> nextOf(previous) }.count { it == true }
    }

    private fun toTable(blackTiles: List<Vector2i>): Table<Boolean> {
        val (minX, maxX) = blackTiles.map { it.x }.minAndMaxOrNull()
            ?: throw IllegalStateException("Je peux rien faire sans ça")
        val (minY, maxY) = blackTiles.map { it.y }.minAndMaxOrNull()
            ?: throw IllegalStateException("Je peux rien faire sans ça")

        val width = maxX - minX + 1
        val height = maxY - minY + 1 + 1
        val deltaY = if (minY % 2 == 0) 1 else 0
        val table = Table(width, height) { false }

        blackTiles.forEach { table[it.x - minX, it.y - minY + deltaY] = true }
        return table
    }

    private fun nextOf(previous: Table<Boolean>): Table<Boolean> {
        val next = Table(previous.width + 2, previous.height + 2) { false }

        for (x in 0 until previous.width + 2) {
            for (y in 0 until previous.height + 2) {
                next[x, y] = shouldBecomeBlack(previous, x - 1, y - 1)
            }
        }

        return next
    }

    /**
     * - Any black tile with zero or more than 2 black tiles immediately adjacent to it is flipped to white.
     * - Any white tile with exactly 2 black tiles immediately adjacent to it is flipped to black.
     */
    private fun shouldBecomeBlack(previous: Table<Boolean>, x: Int, y: Int): Boolean {
        val wasBlack = previous.getOrNull(x, y) ?: false
        val blackNeighbors = countBlackNeighbors(previous, x, y)

        return wasBlack && (blackNeighbors == 1 || blackNeighbors == 2) ||
                !wasBlack && (blackNeighbors == 2)
    }

    private fun countBlackNeighbors(previous: Table<Boolean>, x: Int, y: Int): Int {
        val position = Vector2i(x, y)
        val allNeighbors = Direction.values().map { move(position, it) }
        val blackNeighbors = allNeighbors.filter { previous.getOrNull(it.x, it.y) ?: false }
        return blackNeighbors.count()
    }

    private fun Instruction.toPosition(): Vector2i {
        return directions.fold(Vector2i(0, 0)) { position, direction ->
            move(position, direction)
        }
    }

    private fun move(position: Vector2i, direction: Direction): Vector2i {
        return when (direction) {
            Direction.W -> Vector2i(position.x - 1, position.y)
            Direction.E -> Vector2i(position.x + 1, position.y)
            Direction.NW -> Vector2i(position.x - 1, position.y + 1)
            Direction.NE -> Vector2i(position.x, position.y + 1)
            Direction.SW -> Vector2i(position.x, position.y - 1)
            Direction.SE -> Vector2i(position.x + 1, position.y - 1)
        }
    }

}
