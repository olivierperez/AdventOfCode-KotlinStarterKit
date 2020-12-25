package fr.o80.aoc.day25

fun main() {
    println(Day25().handshake(7L, 8L))
}

class Day25 {

    fun part1(cardPub: Long, doorPubKey: Long): Long {
        val cardLoopSize = loopSizeForPubKey(cardPub)

        return handshake(doorPubKey, cardLoopSize)
    }

    private fun loopSizeForPubKey(pubKey: Long): Long {
        var loop = 0L
        var value = 1L
        do {
            value = (value * 7L) % 20201227L
            loop++
        } while (value != pubKey)
        return loop
    }

    fun handshake(subjectNumber: Long, loopSize: Long): Long {
        return (1..loopSize).fold(1) { acc, _ ->
            (acc * subjectNumber) % 20201227L
        }
    }

}
