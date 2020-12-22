package fr.o80.aoc.day22

import fr.o80.aoc.kit.linesOfInt
import java.util.*

typealias Deck = Deque<Int>

class Day22 {

    fun parse1(player1: String, player2: String): Pair<List<Int>, List<Int>> {
        return Pair(player1.linesOfInt(), player2.linesOfInt())
    }

    fun part1(decks: Pair<List<Int>, List<Int>>): Int {
        val deck1: Deque<Int> = LinkedList(decks.first)
        val deck2: Deque<Int> = LinkedList(decks.second)

        while (deck1.isNotEmpty() && deck2.isNotEmpty()) {
            val card1 = deck1.poll()
            val card2 = deck2.poll()

            if (card1 < card2) {
                deck2.offer(card2)
                deck2.offer(card1)
            } else {
                deck1.offer(card1)
                deck1.offer(card2)
            }
        }

        val deck = deck1 + deck2
        return score(deck)
    }

    fun parse2(player1: String, player2: String): Pair<List<Int>, List<Int>> {
        return Pair(player1.linesOfInt(), player2.linesOfInt())
    }

    fun part2(decks: Pair<List<Int>, List<Int>>): Int {
        val deck1: Deck = LinkedList(decks.first)
        val deck2: Deck = LinkedList(decks.second)

        val (_, deck) = playSubGame("1", deck1, deck2)

        return score(deck)
    }

    private fun playSubGame(name: String, deck1: Deck, deck2: Deck): Pair<Int, Deck> {
        val alreadyPlayed1 = mutableSetOf<Deck>()
        val alreadyPlayed2 = mutableSetOf<Deck>()
        var subName = 1

        while (deck1.isNotEmpty() && deck2.isNotEmpty()) {
            if (deck1 in alreadyPlayed1 || deck2 in alreadyPlayed2) {
                return Pair(1, LinkedList())
            }

            alreadyPlayed1.add(LinkedList(deck1))
            alreadyPlayed2.add(LinkedList(deck2))

            val card1 = deck1.poll()
            val card2 = deck2.poll()

            val winnerOfRound = if (card1 <= deck1.count() && card2 <= deck2.count()) {
                playSubGame("$name.${subName++}", LinkedList(deck1.take(card1)), LinkedList(deck2.take(card2))).first
            } else {
                playRegularRound(card1, card2)
            }

            when (winnerOfRound) {
                1 -> deck1.addAll(listOf(card1, card2))
                2 -> deck2.addAll(listOf(card2, card1))
            }
        }

        return if (deck1.isNotEmpty()) {
            1 to deck1
        } else {
            2 to deck2
        }
    }

    private fun playRegularRound(card1 : Int, card2 : Int) : Int =
        when {
            card1 < card2 -> 2
            else -> 1
        }

    private fun score(deck: Collection<Int>): Int =
        deck.reversed().mapIndexed { index, i -> (index + 1) * i }.sum()

}
