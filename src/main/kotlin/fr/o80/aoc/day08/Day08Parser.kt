package fr.o80.aoc.day08

object Day08Parser {

    fun parse(input: String): List<Operation> {
        return input.lines()
            .map {
                val split = it.split(' ')
                val opName = split[0]
                val value = split[1]

                createOperation(opName, value)
            }
    }

    private fun createOperation(opName: String, value: String): Operation {
        return when (opName) {
            "acc" -> Acc(value.toInt())
            "jmp" -> Jump(value.toInt())
            "nop" -> Noop(value.toInt())
            else -> throw IllegalArgumentException("Ton input pue du cul !")
        }
    }

}
