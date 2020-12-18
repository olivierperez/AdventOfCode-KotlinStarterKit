package fr.o80.aoc.day17

import fr.o80.aoc.kit.table.Dimension3
import fr.o80.aoc.kit.table.Dimension4

private const val ACTIVE = '#'
private const val INACTIVE = '.'

private class Direction3d(val x: Int, val y: Int, val z: Int)
private class Direction4d(val w: Int, val x: Int, val y: Int, val z: Int)

private val directions3d = listOf(
    Direction3d(-1, -1, -1),
    Direction3d(-1, -1, 0),
    Direction3d(-1, -1, +1),
    Direction3d(-1, 0, -1),
    Direction3d(-1, 0, 0),
    Direction3d(-1, 0, +1),
    Direction3d(-1, +1, -1),
    Direction3d(-1, +1, 0),
    Direction3d(-1, +1, +1),
    Direction3d(0, -1, -1),
    Direction3d(0, -1, 0),
    Direction3d(0, -1, +1),
    Direction3d(0, 0, -1),
//    Direction3d(0,0,0),
    Direction3d(0, 0, +1),
    Direction3d(0, +1, -1),
    Direction3d(0, +1, 0),
    Direction3d(0, +1, +1),
    Direction3d(+1, -1, -1),
    Direction3d(+1, -1, 0),
    Direction3d(+1, -1, +1),
    Direction3d(+1, 0, -1),
    Direction3d(+1, 0, 0),
    Direction3d(+1, 0, +1),
    Direction3d(+1, +1, -1),
    Direction3d(+1, +1, 0),
    Direction3d(+1, +1, +1),
)
private val directions4d = listOf(
    Direction4d(-1, -1, -1, -1),
    Direction4d(-1, -1, -1, 0),
    Direction4d(-1, -1, -1, +1),
    Direction4d(-1, -1, 0, -1),
    Direction4d(-1, -1, 0, 0),
    Direction4d(-1, -1, 0, +1),
    Direction4d(-1, -1, +1, -1),
    Direction4d(-1, -1, +1, 0),
    Direction4d(-1, -1, +1, +1),
    Direction4d(-1, 0, -1, -1),
    Direction4d(-1, 0, -1, 0),
    Direction4d(-1, 0, -1, +1),
    Direction4d(-1, 0, 0, -1),
    Direction4d(-1, 0,0,0),
    Direction4d(-1, 0, 0, +1),
    Direction4d(-1, 0, +1, -1),
    Direction4d(-1, 0, +1, 0),
    Direction4d(-1, 0, +1, +1),
    Direction4d(-1, +1, -1, -1),
    Direction4d(-1, +1, -1, 0),
    Direction4d(-1, +1, -1, +1),
    Direction4d(-1, +1, 0, -1),
    Direction4d(-1, +1, 0, 0),
    Direction4d(-1, +1, 0, +1),
    Direction4d(-1, +1, +1, -1),
    Direction4d(-1, +1, +1, 0),
    Direction4d(-1, +1, +1, +1),
    Direction4d(0, -1, -1, -1),
    Direction4d(0, -1, -1, 0),
    Direction4d(0, -1, -1, +1),
    Direction4d(0, -1, 0, -1),
    Direction4d(0, -1, 0, 0),
    Direction4d(0, -1, 0, +1),
    Direction4d(0, -1, +1, -1),
    Direction4d(0, -1, +1, 0),
    Direction4d(0, -1, +1, +1),
    Direction4d(0, 0, -1, -1),
    Direction4d(0, 0, -1, 0),
    Direction4d(0, 0, -1, +1),
    Direction4d(0, 0, 0, -1),
//    Direction4d(0, 0,0,0),
    Direction4d(0, 0, 0, +1),
    Direction4d(0, 0, +1, -1),
    Direction4d(0, 0, +1, 0),
    Direction4d(0, 0, +1, +1),
    Direction4d(0, +1, -1, -1),
    Direction4d(0, +1, -1, 0),
    Direction4d(0, +1, -1, +1),
    Direction4d(0, +1, 0, -1),
    Direction4d(0, +1, 0, 0),
    Direction4d(0, +1, 0, +1),
    Direction4d(0, +1, +1, -1),
    Direction4d(0, +1, +1, 0),
    Direction4d(0, +1, +1, +1),
    Direction4d(+1, -1, -1, -1),
    Direction4d(+1, -1, -1, 0),
    Direction4d(+1, -1, -1, +1),
    Direction4d(+1, -1, 0, -1),
    Direction4d(+1, -1, 0, 0),
    Direction4d(+1, -1, 0, +1),
    Direction4d(+1, -1, +1, -1),
    Direction4d(+1, -1, +1, 0),
    Direction4d(+1, -1, +1, +1),
    Direction4d(+1, 0, -1, -1),
    Direction4d(+1, 0, -1, 0),
    Direction4d(+1, 0, -1, +1),
    Direction4d(+1, 0, 0, -1),
    Direction4d(+1, 0,0,0),
    Direction4d(+1, 0, 0, +1),
    Direction4d(+1, 0, +1, -1),
    Direction4d(+1, 0, +1, 0),
    Direction4d(+1, 0, +1, +1),
    Direction4d(+1, +1, -1, -1),
    Direction4d(+1, +1, -1, 0),
    Direction4d(+1, +1, -1, +1),
    Direction4d(+1, +1, 0, -1),
    Direction4d(+1, +1, 0, 0),
    Direction4d(+1, +1, 0, +1),
    Direction4d(+1, +1, +1, -1),
    Direction4d(+1, +1, +1, 0),
    Direction4d(+1, +1, +1, +1),
)

class Day17 {

    fun parse1(input: String): Dimension3<Char> {
        val lines = input.lines()
        val pocket: Dimension3<Char> = Dimension3.create(
            lines.size,
            lines[0].length,
            1
        ) { _, _, _ -> '_' }

        lines.forEachIndexed { x, line ->
            line.forEachIndexed { y, c ->
                pocket[x, y, 0] = c
            }
        }

        return pocket
    }

    fun part1(pocket: Dimension3<Char>): Int {
        return (1..6)
            .fold(pocket) { acc, _ -> executeCycle(acc) }
            .count { c -> c == ACTIVE }
    }

    private fun executeCycle(pocket: Dimension3<Char>): Dimension3<Char> {
        val nextPocket = Dimension3.create(
            pocket.size1 + 2,
            pocket.size2 + 2,
            pocket.size3 + 2
        ) { _, _, _ -> INACTIVE }

        (0 until nextPocket.size1).forEachIndexed { x, a ->
            (0 until nextPocket.size2).forEachIndexed { y, b ->
                (0 until nextPocket.size3).forEachIndexed { z, c ->
                    if (pocket.shouldBeActive(x - 1, y - 1, z - 1)) {
                        nextPocket[x, y, z] = ACTIVE
                    }
                }
            }
        }

        return nextPocket
    }

    fun parse2(input: String): Dimension4<Char> {
        val lines = input.lines()
        val pocket: Dimension4<Char> = Dimension4.create(
            lines.size,
            lines[0].length,
            1,
            1
        ) { _, _, _, _ -> '_' }

        lines.forEachIndexed { x, line ->
            line.forEachIndexed { y, c ->
                pocket[x, y, 0, 0] = c
            }
        }

        return pocket
    }

    fun part2(pocket: Dimension4<Char>): Int {
        return (1..6)
            .fold(pocket) { acc, _ -> executeCycle(acc) }
            .count { c -> c == ACTIVE }
    }

    private fun executeCycle(pocket: Dimension4<Char>): Dimension4<Char> {
        val nextPocket = Dimension4.create(
            pocket.size1 + 2,
            pocket.size2 + 2,
            pocket.size3 + 2,
            pocket.size4 + 2
        ) { _, _, _, _ -> INACTIVE }

        (0 until nextPocket.size1).forEachIndexed { w, a ->
            (0 until nextPocket.size2).forEachIndexed { x, b ->
                (0 until nextPocket.size3).forEachIndexed { y, c ->
                    (0 until nextPocket.size3).forEachIndexed { z, d ->
                        if (pocket.shouldBeActive(w - 1, x - 1, y - 1, z - 1)) {
                            nextPocket[w, x, y, z] = ACTIVE
                        }
                    }
                }
            }
        }

        return nextPocket
    }

}

private fun Dimension3<Char>.shouldBeActive(x: Int, y: Int, z: Int): Boolean {
    val neighborsCount = countNeighbors(x, y, z)
    val isActive = isActive(x, y, z)

    return when {
        isActive && (neighborsCount == 2 || neighborsCount == 3) -> true
        !isActive && neighborsCount == 3 -> true
        else -> false
    }
}

private fun Dimension3<Char>.countNeighbors(x: Int, y: Int, z: Int): Int {
    var count = 0

    directions3d.forEach { direction ->
        if (isActive(x + direction.x, y + direction.y, z + direction.z)) {
            count++
        }
    }

    return count
}

fun Dimension3<Char>.isActive(x: Int, y: Int, z: Int): Boolean {
    return getOrNull(x, y, z) == ACTIVE
}

private fun Dimension4<Char>.shouldBeActive(w: Int, x: Int, y: Int, z: Int): Boolean {
    val neighborsCount = countNeighbors(w, x, y, z)
    val isActive = isActive(w, x, y, z)

    return when {
        isActive && (neighborsCount == 2 || neighborsCount == 3) -> true
        !isActive && neighborsCount == 3 -> true
        else -> false
    }
}

private fun Dimension4<Char>.countNeighbors(w: Int, x: Int, y: Int, z: Int): Int {
    var count = 0

    directions4d.forEach { direction ->
        if (isActive(w + direction.w, x + direction.x, y + direction.y, z + direction.z)) {
            count++
        }
    }

    return count
}

fun Dimension4<Char>.isActive(w: Int, x: Int, y: Int, z: Int): Boolean {
    return getOrNull(w, x, y, z) == ACTIVE
}
