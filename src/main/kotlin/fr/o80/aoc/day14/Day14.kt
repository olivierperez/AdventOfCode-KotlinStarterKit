package fr.o80.aoc.day14

import fr.o80.aoc.kit.parseInt

sealed class Instruction

class MaskInstruction(
    val mask: String
) : Instruction()

class MemoryInstruction(
    val addr: Long,
    val value: Long
) : Instruction()

data class StatePart(
    var addrMask: String = "",
    var orMask: Long = -1,
    var andMask: Long = -1,
    val memory: MutableMap<Long, Long> = mutableMapOf()
)

class Day14 {

    fun applyMasksOnValues(instructions: Sequence<Instruction>): Long {
        val endState = instructions.fold(StatePart()) { state, instruction ->
            instruction.executePart1(state)
        }
        return endState.memory.values.sum()
    }

    fun applyMasksOnAddresses(instructions: Sequence<Instruction>): Long {
        val endState = instructions.fold(StatePart()) { state, instruction ->
            instruction.executePart2(state)
        }
        return endState.memory.values.sum()
    }

    private fun Instruction.executePart1(state: StatePart): StatePart = when (this) {
        is MemoryInstruction -> {
            val computedValue = value and state.andMask or state.orMask
            state.memory[addr] = computedValue
            state
        }
        is MaskInstruction -> {
            state.andMask = mask.replace('X', '1').parseInt(2)
            state.orMask = mask.replace('X', '0').parseInt(2)
            state
        }
    }

    private fun Instruction.executePart2(state: StatePart): StatePart {
        return when (this) {
            is MemoryInstruction -> {
                val tempAddr = addr and state.andMask or state.orMask
                generateAddrComplements(state.addrMask).forEach { complement ->
                    state.memory[tempAddr + complement] = value
                }
                state
            }
            is MaskInstruction -> {
                state.andMask = mask.replace('0', '1').replace('X', '0').parseInt(2)
                state.orMask = mask.replace('X', '0').parseInt(2)
                state.addrMask = mask.replace('1', '0')
                state
            }
        }
    }

    fun generateAddrComplements(addrMask: String): List<Long> {
        val xPositions = mutableListOf<Int>()
        addrMask.forEachIndexed { index, c -> if (c == 'X') xPositions.add(index) }

        val countOfX = xPositions.size

        return (0 until 1.shl(countOfX))
            .map { v ->
                val chars = addrMask.toCharArray()

                (1..countOfX).forEach { pos ->
                    val bit = v.shr(countOfX - pos) and 1
                    chars[xPositions[pos-1]] = (bit + 48).toChar()
                }

                java.lang.Long.parseLong(String(chars), 2)
            }
            .toList()
    }

}

