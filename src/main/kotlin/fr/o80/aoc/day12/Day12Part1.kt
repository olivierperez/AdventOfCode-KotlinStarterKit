package fr.o80.aoc.day12

import fr.o80.aoc.kit.Vector2i
import kotlin.math.abs

typealias Part1Instruction = (Int, Vector2i, Day12Direction) -> Pair<Vector2i, Day12Direction>
typealias PartialPart1Instruction = (Vector2i, Day12Direction) -> Pair<Vector2i, Day12Direction>

class Day12Part1 {

    fun parse1(input: String): List<PartialPart1Instruction> {
        return input.lines()
            .map { line ->
                val firstLetter = line[0]
                val value = line.substring(1).toInt()
                when (firstLetter) {
                    'F' -> ::forwardPart1.partialPart1(value)
                    'R' -> ::rightPart1.partialPart1(value)
                    'L' -> ::rightPart1.partialPart1(360 - value)
                    'N' -> ::northPart1.partialPart1(value)
                    'E' -> ::eastPart1.partialPart1(value)
                    'S' -> ::northPart1.partialPart1(-value)
                    'W' -> ::eastPart1.partialPart1(-value)
                    else -> throw IllegalArgumentException("Ton input pue : $firstLetter")
                }
            }
    }

    fun part1(instructions: List<PartialPart1Instruction>): Int {
        val initialPosition = Vector2i(0, 0)
        val initialDirection = Day12Direction.EAST
        val lastPosition =
            instructions.fold(Pair(initialPosition, initialDirection)) { (position, direction), instruction ->
                instruction(position, direction)
            }.first
        return abs(lastPosition.x) + abs(lastPosition.y)
    }

    private fun eastPart1(
        value: Int,
        position: Vector2i,
        direction: Day12Direction
    ): Pair<Vector2i, Day12Direction> {
        return Pair(Vector2i(position.x + value, position.y), direction)
    }

    private fun northPart1(
        value: Int,
        position: Vector2i,
        direction: Day12Direction
    ): Pair<Vector2i, Day12Direction> {
        return Pair(Vector2i(position.x, position.y + value), direction)
    }

    private fun rightPart1(
        value: Int,
        position: Vector2i,
        direction: Day12Direction
    ): Pair<Vector2i, Day12Direction> {
        val notch = value / 90
        val newDirectionOrdinal = (direction.ordinal + notch) % Day12Direction.values().size
        val newDirection = Day12Direction.values()[newDirectionOrdinal]
        return Pair(position, newDirection)
    }

    private fun forwardPart1(
        value: Int,
        position: Vector2i,
        direction: Day12Direction
    ): Pair<Vector2i, Day12Direction> {
        val newX = position.x + direction.x * value
        val newY = position.y + direction.y * value
        return Pair(Vector2i(newX, newY), direction)
    }

    private fun Part1Instruction.partialPart1(value: Int): PartialPart1Instruction =
        { position, direction -> this(value, position, direction) }

}
