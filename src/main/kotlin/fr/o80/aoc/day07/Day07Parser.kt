package fr.o80.aoc.day07

object Day07Parser {

    private val lineRegex = "^(.+) bags contain (.+)\\.$".toRegex()
    private val innerBagsRegex = "(?:(\\d+) ([a-z ]+) bag)".toRegex()

    fun parse(input: String): Map<BagColor, List<BagColor>> {
        return input.lines()
            .map(::splitLine)
            .toMap()
    }

    private fun splitLine(line: String): Pair<BagColor, List<BagColor>> {
        return lineRegex.find(line)
            ?.let { result ->
                val bagColor = result.groupValues[1]
                val innerBagColors = splitInnerBags(result.groupValues[2])

                Pair(BagColor(1, bagColor), innerBagColors)
            } ?: throw IllegalArgumentException("Tu me passe des data pourries: $line")
    }

    private fun splitInnerBags(innerRules: String): List<BagColor> {
        return if (innerRules == "no other bags") {
            emptyList()
        } else {
            innerBagsRegex.findAll(innerRules)
                .map { result ->
                    BagColor(
                        count = result.groupValues[1].toInt(),
                        name = result.groupValues[2]
                    )
                }
                .toList()
        }
    }
}
