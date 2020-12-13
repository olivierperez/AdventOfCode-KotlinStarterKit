package fr.o80.aoc.day13

object Day13Parser {

    fun parse(input: String): Day13Input {
        val lines = input.lines()
        val timestamp = lines[0].toInt()
        val buses = lines[1].split(',').mapIndexedNotNull { index, busId ->
            if (busId == "x") {
                null
            } else {
                Bus(index, busId.toLong())
            }

        }
        return Day13Input(timestamp, buses)
    }

}
