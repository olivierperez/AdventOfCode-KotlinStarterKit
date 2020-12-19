package fr.o80.aoc.day18

import fr.o80.aoc.kit.tryToLong
import java.util.*

class Instruction(
    val parts: List<String>
)

class Day18 {

    private lateinit var hasPrecedence: (op1: Char, op2: Char) -> Boolean

    fun parse(input: String): List<Instruction> {
        return input.lines()
            .map {  line -> Instruction(line.split(' ')) }
    }

    fun part1(instructions: List<Instruction>): Long {
        hasPrecedence = { _, op2 ->
            when (op2) {
                '(', ')' -> false
                else -> true
            }
        }
        return instructions.sumOf { instruction -> instruction.compute() }
    }

    fun part2(instructions: List<Instruction>): Long {
        hasPrecedence = { op1, op2 ->
            when {
                op2 == '(' || op2 == ')' -> false
                (op1 == '+' || op1 == '/') && (op2 == '*' || op2 == '-') -> false
                else -> true
            }
        }
        return instructions.sumOf { instruction -> instruction.compute() }
    }

    private fun Instruction.compute(): Long {
        val values = ArrayDeque<Long>()
        val ops = ArrayDeque<Char>()

        parts.forEach { part ->
            val value = part.tryToLong()
            when {
                value != null -> {
                    values.offer(value)
                }
                part == "+" -> {
                    executePreviousOps('+', values, ops)
                    ops.offer('+')
                }
                part == "-" -> {
                    executePreviousOps('-', values, ops)
                    ops.offer('-')
                }
                part == "*" -> {
                    executePreviousOps('*', values, ops)
                    ops.offer('*')
                }
                part == "/" -> {
                    executePreviousOps('/', values, ops)
                    ops.offer('/')
                }
                part == "(" -> {
                    ops.offer('(')
                }
                part == ")" -> {
                    executeParenthesis(values, ops)
                }
                else -> {
                    throw IllegalArgumentException("What do you think \"$part\" is?")
                }
            }
        }

        executePreviousOps('_', values, ops)

        return values.pop()
    }

    private fun executePreviousOps(op: Char, values: ArrayDeque<Long>, ops: ArrayDeque<Char>) {
        while (ops.isNotEmpty() && hasPrecedence(op, ops.peekLast())) {
            val a = values.removeLast()
            val b = values.removeLast()
            values.offer(ops.removeLast().invoke(a, b))
        }
    }

    private fun executeParenthesis(values: ArrayDeque<Long>, ops: ArrayDeque<Char>) {
        while (ops.peekLast() != '(') {
            val a = values.removeLast()
            val b = values.removeLast()
            values.offer(ops.removeLast().invoke(a, b))
        }
        ops.removeLast()
    }

    private fun Char.invoke(a: Long, b: Long): Long {
        return when (this) {
            '+' -> a + b
            '-' -> a - b
            '*' -> a * b
            '/' -> a / b
            else -> throw IllegalArgumentException("Nope nope nope !")
        }
    }

}
