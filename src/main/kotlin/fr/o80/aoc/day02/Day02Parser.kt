package fr.o80.aoc.day02

object Day02Parser {
    fun parse(input: String): Sequence<Day02.Line> {
        val liveRegex = "^(\\d+)-(\\d+) ([a-z]): (.+)$".toRegex()

        return input.lineSequence()
            .mapNotNull { line ->
                liveRegex.matchEntire(line)?.let { result ->
                    Day02.Line(
                        one = result.groupValues[1].toInt(),
                        two = result.groupValues[2].toInt(),
                        letter = result.groupValues[3][0],
                        password = result.groupValues[4],
                    )
                }
            }
    }
}
