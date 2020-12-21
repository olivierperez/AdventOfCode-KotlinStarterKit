package fr.o80.aoc.day21

object Day21Parser {

    fun parse(input: String): List<AllergenInfo> {
        return input.lines().map(::parseAllergenInfo)
    }

    private fun parseAllergenInfo(line: String): AllergenInfo {
        val split = line.split(" | ")
        return AllergenInfo(
            ingredients = split[0].split(' '),
            allergens = split[1].split(", ")
        )
    }
}