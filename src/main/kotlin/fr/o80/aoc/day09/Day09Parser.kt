package fr.o80.aoc.day09

object Day09Parser {
    fun parse(input: String): List<Long> {
        return input.lines().map { it.toLong() }
    }
}