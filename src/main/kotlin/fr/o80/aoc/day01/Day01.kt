package fr.o80.aoc.day01

class Day01 {

    fun part1(parsed: Array<Boolean>): Int {
        parsed.forEachIndexed { index, x ->
            if (index == 0) return@forEachIndexed
            if (!x) return@forEachIndexed

            val complement = 2020 - index
            val matched = parsed[complement]
            if (matched) {
                return index * complement
            }
        }

        throw IllegalArgumentException("Ton livre compte est tout pété")
    }

    fun parse1(input: String): Array<Boolean> {
        val numbers = Array(2020) { false }
        input.lines().onEach { numbers[it.toInt()] = true }
        return numbers
    }

    fun part2(parsed: Array<Boolean>): Int {
        parsed.forEachIndexed { outerIndex, x ->
            if (outerIndex > 0 && x) {
                parsed.forEachIndexed { innerIndex, y ->
                    if (innerIndex > 0 && y) {
                        val complement = 2020 - outerIndex - innerIndex
                        val matched = parsed[complement]
                        if (matched) {
                            return outerIndex * innerIndex * complement
                        }
                    }
                }
            }
        }

        throw IllegalArgumentException("Ton livre compte est tout pété")
    }

    fun parse2(input: String): Array<Boolean> {
        return parse1(input)
    }

}
