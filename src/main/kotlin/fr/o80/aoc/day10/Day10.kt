package fr.o80.aoc.day10

import fr.o80.aoc.kit.linesOfInt
import fr.o80.aoc.kit.sequenceOfInt

data class Adapters(
    val ones: Int = 0,
    val threes: Int = 0,
    val last: Int = 0
)

class Day10 {

    fun part1(input: Sequence<Int>): Adapters {
        return input.sorted().fold(Adapters(threes = 1)) { adapters, num ->
            when (val diff = num - adapters.last) {
                1 -> adapters.copy(ones = adapters.ones + 1, last = num)
                3 -> adapters.copy(threes = adapters.threes + 1, last = num)
                else -> throw IllegalArgumentException("Diff = $diff !?")
            }
        }
    }

    fun parse1(input: String): Sequence<Int> {
        return input.sequenceOfInt()
    }

    fun part2(input: List<Int>): Long {
        return availableMutations(0, input.sorted())
    }

    private fun availableMutations(from: Int, input: List<Int>, memo: MutableMap<Int, Long> = mutableMapOf()): Long {
        if (input.isEmpty()) return 1
        if (memo.containsKey(from)) return memo[from]!!

        val nextThree = input.subList(0, 3.coerceAtMost(input.size))

        var possibilities = 0L
        if (from + 1 in nextThree) {
            possibilities += availableMutations(input[0], input.subList(1, input.size), memo)
        }
        if (from + 2 in nextThree) {
            possibilities += availableMutations(from + 2, input.filter { it > from + 2 }, memo)
        }
        if (from + 3 in nextThree) {
            possibilities += availableMutations(from + 3, input.filter { it > from + 3 }, memo)
        }

        return possibilities.also {
            memo[from] = it
        }
    }

    fun parse2(input: String): List<Int> {
        return input.linesOfInt()
    }

}
