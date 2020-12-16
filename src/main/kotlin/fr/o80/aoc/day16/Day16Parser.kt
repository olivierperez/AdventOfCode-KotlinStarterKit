package fr.o80.aoc.day16

object Day16Parser {

    fun parse(rules: String, myTicket: String, nearbyTickets: String): Day16Input {
        return Day16Input(
            rules = rules.lines().map(::parseRuleLine),
            myTicket = parseTicketLine(myTicket),
            nearbyTickets = nearbyTickets.lines().map(::parseTicketLine)
        )
    }

    private fun parseTicketLine(myTicket: String): Ticket {
        val numbers = myTicket
            .split(',')
            .map { it.toLong() }

        return Ticket(numbers)
    }

    private fun parseRuleLine(ruleLine: String): Rule {
        val split = ruleLine.split(": ")
        val name = split[0]

        val rules = split[1]
        val ranges = rules.split(" or ").map(::parseRange)

        return Rule(name, ranges)
    }

    private fun parseRange(rangeStr: String): IntRange {
        val split = rangeStr.split('-')
        return split[0].toInt()..split[1].toInt()
    }

}
