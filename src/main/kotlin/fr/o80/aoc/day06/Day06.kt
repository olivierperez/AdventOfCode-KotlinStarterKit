package fr.o80.aoc.day06

class Day06 {

    fun part1(groups: List<String>): List<Int> {
        return groups.map(::countEachYes)
    }

    fun part2(groups: List<String>): List<Int> {
        return groups.map(::countMatchingYes)
    }

    private fun countEachYes(group: String): Int {
        val yes = mutableSetOf<Char>()
        group.lines()
            .forEach { line ->
                line.forEach { c -> yes.add(c) }
            }
        return yes.size
    }

    private fun countMatchingYes(group: String): Int {
        val yes = "azertyuiopqsdfghjklmwxcvbn".toMutableList()
        group.lines()
            .forEach { line ->
                yes.removeIf { it !in line }
            }
        return yes.size
    }

}
