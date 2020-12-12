package fr.o80.aoc.day12

import fr.o80.aoc.kit.Vector2i
import kotlin.math.abs

typealias Part2Instruction = (Int, Vector2i, Vector2i) -> Pair<Vector2i, Vector2i>
typealias PartialPart2Instruction = (Vector2i, Vector2i) -> Pair<Vector2i, Vector2i>

class Day12Part2 {

    fun parse2(input: String): List<PartialPart2Instruction> {
        return input.lines()
            .map { line ->
                val firstLetter = line[0]
                val value = line.substring(1).toInt()
                when (firstLetter) {
                    'F' -> ::forwardPart2.partialPart2(value)
                    'R' -> ::rightPart2.partialPart2(value)
                    'L' -> ::rightPart2.partialPart2(360 - value)
                    'N' -> ::northPart2.partialPart2(value)
                    'E' -> ::eastPart2.partialPart2(value)
                    'S' -> ::northPart2.partialPart2(-value)
                    'W' -> ::eastPart2.partialPart2(-value)
                    else -> throw IllegalArgumentException("Ton input pue : $firstLetter")
                }
            }
    }

    fun part2(instructions: List<PartialPart2Instruction>): Int {
        val initialPosition = Vector2i(0, 0)
        val initialWaypoint = Vector2i(10, 1)
        val lastPosition =
            instructions.fold(Pair(initialPosition, initialWaypoint)) { (position, waypoint), instruction ->
                instruction(position, waypoint)
            }.first

        return abs(lastPosition.x) + abs(lastPosition.y)
    }

    private fun eastPart2(value: Int, position: Vector2i, waypoint: Vector2i): Pair<Vector2i, Vector2i> {
        val newX = waypoint.x + value
        return Pair(position, Vector2i(newX, waypoint.y))
    }

    private fun northPart2(value: Int, position: Vector2i, waypoint: Vector2i): Pair<Vector2i, Vector2i> {
        val newY = waypoint.y + value
        return Pair(position, Vector2i(waypoint.x, newY))
    }

    private fun rightPart2(value: Int, position: Vector2i, waypoint: Vector2i): Pair<Vector2i, Vector2i> {
        val newWaypoint = when (value / 90) {
            1 -> Vector2i(waypoint.y, -waypoint.x)
            2 -> Vector2i(-waypoint.x, -waypoint.y)
            3 -> Vector2i(-waypoint.y, waypoint.x)
            else -> throw IllegalArgumentException("Je ne sais pas gérer les rotations de $value°")
        }
        return Pair(position, newWaypoint)
    }

    private fun forwardPart2(value: Int, position: Vector2i, waypoint: Vector2i): Pair<Vector2i, Vector2i> {
        val newX = position.x + value * waypoint.x
        val newY = position.y + value * waypoint.y
        return Pair(Vector2i(newX, newY), waypoint)
    }

    private fun Part2Instruction.partialPart2(value: Int): PartialPart2Instruction =
        { position, direction -> this(value, position, direction) }

}
