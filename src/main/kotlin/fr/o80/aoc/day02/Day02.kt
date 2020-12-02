package fr.o80.aoc.day02

class Day02 {

    class Line(val one: Int, val two: Int, val letter: Char, val password: String)

    fun part1(parsed: Sequence<Line>): Int {
        return parsed
            .count(::isOldJobPasswordValid)
    }

    fun part2(parsed: Sequence<Line>): Int {
        return parsed
            .count(::isCurrentJobPasswordValid)
    }

    private fun isOldJobPasswordValid(line: Line): Boolean {
        val count = line.password.count { it == line.letter }
        return count in line.one..line.two
    }

    private fun isCurrentJobPasswordValid(line: Line): Boolean {
        val oneIsGood = line.password[line.one - 1] == line.letter
        val twoIsGood = line.password[line.two - 1] == line.letter
        return oneIsGood xor twoIsGood
    }

}
