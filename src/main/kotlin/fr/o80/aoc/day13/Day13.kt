package fr.o80.aoc.day13

class Day13Input(
    val timestamp: Int,
    val buses: List<Bus>
)

class Bus(
    val index: Int,
    val id: Long
) {
    fun canStartAt(timestamp: Long): Boolean {
        return timestamp % id == 0L
    }
}

class Day13 {

    fun part1(input: Day13Input): Long {
        return input.buses
            .map { bus ->
                val busStartAfter = bus.id - input.timestamp % bus.id
                Pair(bus, busStartAfter)
            }
            .minByOrNull { it.second }!!
            .let { it.first.id * it.second }
    }

    fun part2(input: Day13Input): Long {
        var timestamp = 0L
        var numberOfBusesToSearch = 1
        var inc = input.buses[0].id

        do {
            if (input.buses.canStartAt(timestamp)) {
                break
            }

            val busesToSearch = input.buses.filterIndexed { index, _ -> index <= numberOfBusesToSearch }
            if (busesToSearch.canStartAt(timestamp)) {
                inc *= input.buses[numberOfBusesToSearch].id
                numberOfBusesToSearch++
            }

            timestamp += inc
        } while (true)

        return timestamp
    }

    private fun List<Bus>.canStartAt(timestamp: Long) =
        this.all { bus -> bus.canStartAt(timestamp + bus.index) }

}
