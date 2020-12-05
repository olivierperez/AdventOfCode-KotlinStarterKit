package fr.o80.aoc.day05

import fr.o80.aoc.kit.minAndMaxOrNull

class Day05 {

    fun highestSeatId(seatsId: Sequence<Int>): Int {
        return seatsId.maxOrNull() ?: throw IllegalArgumentException("Quoi ?")
    }

    fun mySeatId(seatsId: Sequence<Int>): Int {
        val (min, max) = seatsId.minAndMaxOrNull() ?: throw IllegalArgumentException("Pas de min ? Vraiment ?")

        return (min..max).fold(0) { acc, elem -> acc xor elem } xor
                seatsId.fold(0) { acc, elem -> acc xor elem }
    }

    fun parseToSeatId(input: String): Sequence<Int> {
        return input.lineSequence()
            .map {
                it
                    .replace('F', '0')
                    .replace('L', '0')
                    .replace('B', '1')
                    .replace('R', '1')
            }
            .map {
                Integer.parseInt(it, 2)
            }
    }

}
