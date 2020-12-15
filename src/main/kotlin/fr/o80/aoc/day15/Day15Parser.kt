package fr.o80.aoc.day15

object Day15Parser {
    fun parse(input: String): List<Int> {
        return input.split(',').map { it.toInt() }
    }
}