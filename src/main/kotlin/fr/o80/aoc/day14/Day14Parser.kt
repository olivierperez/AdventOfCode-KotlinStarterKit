package fr.o80.aoc.day14

object Day14Parser {
    fun parse(input: String): Sequence<Instruction> {
        val memoryRegex = "^mem\\[(\\d+)] = (\\d+)$".toRegex()
        return input.lineSequence()
            .map {
                if (it.startsWith("ma")) {
                    MaskInstruction(it.substring(7))
                } else {
                    memoryRegex.find(it)?.let { result ->
                        MemoryInstruction(
                            addr = result.groupValues[1].toLong(),
                            value = result.groupValues[2].toLong()
                        )
                    } ?: throw IllegalArgumentException("Memory instruction malformed: \"$it\"")
                }
            }
    }
}
