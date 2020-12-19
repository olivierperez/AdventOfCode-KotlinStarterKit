package fr.o80.aoc.day19

object Day19Parser {

    fun parse(rules: String, messages: String): Day19Input {
        return Day19Input(
            rules = rules.lines().map(::parseRule).toMap(),
            messages = messages.lines()
        )
    }

    private fun parseRule(line: String): Pair<Int, Rule> {
        val split = line.split(": ")
        val id = split[0].toInt()
        val ruleStr = split[1]

        val rule = when {
            ruleStr.startsWith('"') -> parseLetterRule(ruleStr)
            ruleStr.contains('|') -> parseComplexRule(ruleStr)
            else -> parseSimpleRule(ruleStr)
        }

        return Pair(id, rule)
    }

    private fun parseSimpleRule(ruleStr: String): SimpleRule {
        return SimpleRule(ruleStr.split(' ').map { it.toInt() })
    }

    private fun parseComplexRule(ruleStr: String): ComplexRule {
        return ComplexRule(
            ruleStr.split(" | ").map { parseSimpleRule(it) }
        )
    }

    private fun parseLetterRule(ruleStr: String): LetterRule {
        return LetterRule(ruleStr.replace("\"", ""))
    }

}
