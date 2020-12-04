package fr.o80.aoc.day04

object Day04Parser {
    fun parse(input: String): List<Passport> {
        return input.split("\n\n")
            .map { passportInput ->
                val passport = Passport()
                passportInput.lineSequence()
                    .forEach { line ->
                        val split = line.split(':')
                        val k = Key.from(split[0])

                        k?.let {
                            passport[k] = split[1]
                        }
                    }
                passport
            }
    }
}