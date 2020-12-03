package fr.o80.aoc.day03

import fr.o80.aoc.kit.table.Table

object Day03Parser {
    fun parse(input: String): Table<Geology> {
        val lines = input.lines()
        val table = Table<Geology>(lines[0].length, lines.size)

        lines.forEachIndexed { y, line ->
            line.forEachIndexed { x, char ->
                val geology = when (char) {
                    '.' -> Geology.SQUARE
                    '#' -> Geology.TREE
                    else -> throw IllegalArgumentException("unknown geology: $char")
                }

                table[x, y] = geology
            }
        }

        return table
    }
}