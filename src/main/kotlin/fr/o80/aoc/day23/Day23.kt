package fr.o80.aoc.day23

class Day23 {

    fun parse(input: String): Circle<Int> {
        val circle = Circle<Int>()
        input.toList().map { it - '0' }.forEach {
            circle.add(it)
        }
        return circle
    }

    fun part1(moves: Int, circle: Circle<Int>): String {
        doAllTheMoves(moves, circle)

        circle.toString()
        val list = circle.toList().toMutableList()
        val indexOfOne = list.indexOf(1)
        list.removeAt(indexOfOne)

        var result = ""
        (indexOfOne until list.size).forEach { index ->
            result += list[index]
        }
        (0 until indexOfOne).forEach { index ->
            result += list[index]
        }

        return result
    }

    fun part2(moves: Int, circle: Circle<Int>): Long {
        (10..1_000_000).forEach { circle.add(it) }
        doAllTheMoves(moves, circle)

        val list = circle.toList()
        val indexOfOne = list.indexOf(1)
        val a = list[(indexOfOne + 1) % list.size].toLong()
        val b = list[(indexOfOne + 2) % list.size].toLong()

        return a * b
    }

    private fun doAllTheMoves(moves: Int, circle: Circle<Int>) {
        var loop = 0
        while (loop++ < moves) {
            applyRound(circle)
        }
    }

    private fun applyRound(
        circle: Circle<Int>
    ) {
        val maxValue = circle.size
        val currentValue = circle.next()
        val a = circle.popNext()
        val b = circle.popNext()
        val c = circle.popNext()

        val destinationLabel = findDestinationLabel(currentValue, maxValue, a, b, c)

        circle.addAllAfter(destinationLabel, listOf(a, b, c))
    }

    private fun findDestinationLabel(
        currentValue: Int,
        maxValue: Int,
        a: Int,
        b: Int,
        c: Int
    ): Int {
        var destinationLabel: Int = currentValue

        do {
            destinationLabel -= 1
            if (destinationLabel < 1) {
                destinationLabel = maxValue
            }
        } while (
            destinationLabel == a ||
            destinationLabel == b ||
            destinationLabel == c
        )

        return destinationLabel
    }

}
