package fr.o80.aoc.day09

import fr.o80.aoc.kit.minAndMaxOrNull
import fr.o80.aoc.kit.rangequery.RangeQuery

class Day09 {

    fun findNumberThatIsNotSumOfPreamble(preamble: Long, numbers: List<Long>): Long {
        val wrongIndex = findWrongIndex(preamble, numbers)
        return numbers[wrongIndex.toInt()]
    }

    fun findRangeToSumToThePart1(preamble: Long, numbers: List<Long>): Long {
        val wrongIndex = findWrongIndex(preamble, numbers)
        val wrongNumber = numbers[wrongIndex.toInt()]

        val rangeQuery = RangeQuery(
            key = numbers,
            initial = 0L,
            applyMutation = { a, b -> a + b },
            unapplyMutation = { b, a -> b - a }
        )

        val alreadySeen = HashMap<Long, Int>(numbers.size * 2)

        for ((index, a) in rangeQuery.preCalculatedMutations.withIndex()) {
            val rest = a - wrongNumber
            val indexOfRest = alreadySeen[rest]

            if (rest != 0L && indexOfRest != null) {
                val list = numbers.subList(indexOfRest, index)
                return sumMinAndMaxOf(list)
            }

            alreadySeen[a] = index
        }

        throw IllegalArgumentException("Va chercher un autre input mon poste !")
    }

    private fun findWrongIndex(preamble: Long, numbers: List<Long>): Long {
        return (preamble until numbers.size).first { index ->
            val from = index - preamble
            !numbers[index.toInt()].canBeSumOfTwoOf(numbers.subList(from.toInt(), index.toInt()))
        }
    }

    private fun sumMinAndMaxOf(list: List<Long>): Long {
        return list.minAndMaxOrNull()?.let { (min, max) -> min + max }
            ?: throw IllegalArgumentException("Ta list n'a pas de min et max $list")
    }

    private fun Long.canBeSumOfTwoOf(previous: List<Long>): Boolean {
        val alreadySeen = HashSet<Long>(previous.size * 2)

        for (a in previous) {
            val rest = this - a
            if (rest == a) continue
            if (alreadySeen.contains(rest)) return true
            alreadySeen.add(a)
        }

        return false
    }

}
