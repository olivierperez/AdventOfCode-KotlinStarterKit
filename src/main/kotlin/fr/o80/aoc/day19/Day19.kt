package fr.o80.aoc.day19

sealed class Rule
class LetterRule(val letter: String) : Rule()
class SimpleRule(val subRules: List<Int>) : Rule()
class ComplexRule(val orRules: List<SimpleRule>) : Rule()

data class Day19Input(
    val rules: Map<Int, Rule>,
    val messages: List<String>
)

/*
8: 42 | 42 8
11: 42 31 | 42 11 31

8: 42+
11: 42{x} 31{x}

 */

class Day19 {

    private val numRegex = "#(\\d+)#".toRegex()

    fun part1(input: Day19Input): Int {
        val regex = toRecursiveRegex(0, input.rules, mutableMapOf()).toRegex()
        return input.messages.count { regex.matches(it) }
    }

    fun part2(input: Day19Input): Int {
        var totalRegexStr = "#0#"
        while (totalRegexStr.contains("#")) {
            totalRegexStr = totalRegexStr.applyRegex(input.rules)
        }

        val regex = totalRegexStr.toRegex()
        return input.messages.count { message -> regex.matches(message) }
    }

    private fun String.applyRegex(rules: Map<Int, Rule>): String {
        var output = this

        numRegex.findAll(this).forEach { result ->
            val n = result.groupValues[1].toInt()
            val rule = rules[n]!!
            output = output.replace("#$n#", rule.toRegex())
        }

        output = output.replace("#8#", "(?:#42#)+")
        output = output.replace("#11#", buildRegexFor11())

        return output
    }

    private fun buildRegexFor11(): String {
        return (1..10).joinToString("|", prefix = "(?:", postfix = ")") { "(?:#42#){$it}(?:#31#){$it}" }
    }

    private fun Rule.toRegex(): String {
        return when (this) {
            is LetterRule ->
                letter
            is SimpleRule ->
                subRules.joinToString("") { subRuleId ->
                    "#$subRuleId#"
                }
            is ComplexRule ->
                orRules.joinToString("|", prefix = "(?:", postfix = ")") { simpleRule ->
                    simpleRule.subRules.joinToString("") { subRuleId ->
                        "#$subRuleId#"
                    }
                }
        }
    }

    private fun toRecursiveRegex(id: Int, rules: Map<Int, Rule>, memo: MutableMap<Int, String>): String {
        return toRecursiveRegex(id, rules[id]!!, rules, memo)
    }

    private fun toRecursiveRegex(id: Int?, rule: Rule, rules: Map<Int, Rule>, memo: MutableMap<Int, String>): String {
        val regex = when (rule) {
            is LetterRule ->
                rule.letter
            is SimpleRule ->
                rule.subRules.joinToString("") { subId ->
                    toRecursiveRegex(subId, rules, memo)
                        .also { result -> memo[subId] = result }
                }
            is ComplexRule ->
                rule.orRules.joinToString("|", prefix = "(?:", postfix = ")") {
                    toRecursiveRegex(null, it, rules, memo)
                }
        }
        id?.let { memo[id] = regex }
        return regex
    }

}
