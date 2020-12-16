package fr.o80.aoc.day16

class Day16Input(
    val rules: List<Rule>,
    val myTicket: Ticket,
    val nearbyTickets: List<Ticket>
)

data class Rule(
    val name: String,
    val ranges: List<IntRange>
)

class Ticket(
    val numbers: List<Long>
)

data class Field(
    val index: Int,
    val rules: List<Rule>
)

data class FixedField(
    val index: Int,
    val rule: Rule
)

class Day16 {

    fun part1(input: Day16Input): Long {
        return input.nearbyTickets
            .mapNotNull { nearbyTicket -> getInvalidNumberOrNull(nearbyTicket, input.rules) }
            .sum()
    }

    fun part2(input: Day16Input): Long {
        val validTickets = input.nearbyTickets
            .filter { nearbyTicket -> getInvalidNumberOrNull(nearbyTicket, input.rules) == null }
        val allTickets = validTickets + input.myTicket

        val fields = input.myTicket.numbers.indices.map { numberIndex ->
            val matchingRules = input.rules.filter { rule ->
                allTickets.all { ticket ->
                    ticket.numbers[numberIndex] matches rule
                }
            }

            Field(numberIndex, matchingRules.toMutableList())
        }

        val fixedFields = fixFields(fields)

        return fixedFields
            .filter { (_, rule) -> rule.name.startsWith("departure ") }
            .fold(1) { acc, field -> acc * input.myTicket.numbers[field.index] }
    }

    private fun getInvalidNumberOrNull(ticket: Ticket, rules: List<Rule>): Long? {
        return ticket.numbers.firstOrNull { number ->
            rules.none { rule -> number matches rule }
        }
    }

    private infix fun Long.matches(rule: Rule): Boolean {
        return rule.ranges.any { range -> this in range }
    }

    private fun fixFields(fields: List<Field>): List<FixedField> {
        val fixedField = mutableListOf<FixedField>()
        var remaining = fields

        while (remaining.isNotEmpty()) {
            val alreadyFixed = remaining.filter { (_, rules) -> rules.size == 1 }
            alreadyFixed.forEach { (fixedKey, value) ->
                fixedField.add(FixedField(fixedKey, value[0]))
                remaining = remaining
                    .filter { (key, _) -> key != fixedKey }
                    .map { (key, rules) -> Field(key, rules.filter { it != value[0] }) }
            }
        }

        return fixedField
    }

}

