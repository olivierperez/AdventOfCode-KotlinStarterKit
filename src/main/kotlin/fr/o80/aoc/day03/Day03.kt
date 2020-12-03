package fr.o80.aoc.day03

import fr.o80.aoc.kit.table.Table
import fr.o80.aoc.kit.Vector2i

class Day03 {

    fun computePart1(parsed: Table<Geology>): List<Geology> {
        var position = Vector2i(0, 0)

        return (0 until parsed.height)
            .map {
                val geology = parsed[position.x % parsed.width, position.y]!!
                position += Vector2i(3, 1)

                geology
            }
    }

    fun part2(parsed: Table<Geology>): Array<Slope> {

        val slopes = arrayOf(
            Slope(xStep = 1, yStep = 1),
            Slope(xStep = 3, yStep = 1),
            Slope(xStep = 5, yStep = 1),
            Slope(xStep = 7, yStep = 1),
            Slope(xStep = 1, yStep = 2),
        )

        (0 until parsed.height).forEach { lineNumber ->
            slopes
                .filter { slope -> lineNumber % slope.yStep == 0 }
                .forEach { slope ->
                    val geology = parsed[slope.x, lineNumber]!!
                    slope.x = (slope.x + slope.xStep) % parsed.width
                    if (geology == Geology.TREE) {
                        slope.trees++
                    }
                }
        }

        return slopes
    }

}

fun List<Geology>.countTrees(): Int {
    return this.sumBy { geology ->
        if (geology == Geology.TREE) 1
        else 0
    }
}

fun Array<Slope>.multiplyTrees(): Long {
    return this
        .map { slope -> slope.trees }
        .fold(1L) { acc, elem -> acc * elem }
}
