package fr.o80.aoc.kit.knapsack

import fr.o80.aoc.kit.table.Table

/**
    // Example

    ```
    val packets: List<Packet> = input
        .filterIndexed { index, _ -> index != 0 }
        .map(::toPacket)
        .sortedBy { -it.volume }
        .toList()

    val truckSize = packets.sumBy { it.volume } / 2

    val knapsack = Knapsack<Packet>(
        items = packets,
        capacity = truckSize,
        interestOf = { it.volume },
        costOf = { it.volume }
    )
    val result: Knapsack.Info<Packet> = knapsack.compute()

    val firstTruck = result.items
    val secondTruck = packets - firstTruck
    ```
*/
class Knapsack<T>(
    private val items: List<T>,
    private val capacity: Int,
    private val interestOf: (T) -> Int,
    private val costOf: (T) -> Int
) {

    private val table = Table<KnapsackInfo<T>>(capacity + 1, items.size + 1)

    fun compute(): KnapsackInfo<T> {
        for (i in 0..items.size) {
            for (c in 0..capacity) {
                when {
                    i == 0 -> table[c, 0] = KnapsackInfo(0, emptyList())
                    c == 0 -> table[0, i] = KnapsackInfo(0, emptyList())
                    else -> {
                        table[c,i] = fillKnapsack(
                            item = items[i - 1],
                            c = c,
                            i = i
                        )
                    }
                }
            }
        }

        return table[capacity, items.size]!!
    }

    fun debug() {
        table.debug()
    }

    private fun fillKnapsack(item: T, c: Int, i: Int): KnapsackInfo<T> {
        if (i == 0) {
            return KnapsackInfo(0, emptyList())
        }

        val wi = costOf(item)
        val pi = interestOf(item)

        return if (c >= pi) {
            val sameInfoForLessCapacity = table[c, i - 1]!!
            val otherCell = table[c - pi, i - 1]!!

            val firstValue = sameInfoForLessCapacity.value
            val secondValue = otherCell.value + wi
            if (firstValue >= secondValue) {
                sameInfoForLessCapacity
            } else {
                KnapsackInfo(secondValue, otherCell.items + item)
            }
        } else {
            table[c, i - 1]!!
        }
    }
}
