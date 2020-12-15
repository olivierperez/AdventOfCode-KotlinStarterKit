package fr.o80.aoc.day15

data class Number(
    val index: Int,
    val age: Int
)

class Day15(private val startingNumbers: List<Int>) {

    private val ages: MutableMap<Int, Number> = mutableMapOf()

    fun findThe2020th(): Int {
        return findNthNumberSaid(2020)
    }

    fun findThe30000000th(): Int {
        return findNthNumberSaid(30000000)
    }

    private fun findNthNumberSaid(loops: Int) =
        (1..loops).fold(-1) { previous, index ->
            val number = if (index <= startingNumbers.size) {
                peekStartingNumber(index)
            } else {
                getAgeOf(previous, index)
            }

            number
        }

    private fun peekStartingNumber(index: Int): Int {
        return startingNumbers[index - 1].also {
            ages[it] = Number(index, 0)
        }
    }

    private fun getAgeOf(previous: Int, index: Int): Int {
        return ages[previous]!!.age.also {
            val lastSeenOfIt = ages[it]?.index
            val ageOfIt: Int = lastSeenOfIt?.let { index - lastSeenOfIt } ?: 0
            ages[it] = Number(index, ageOfIt)
        }
    }

}
