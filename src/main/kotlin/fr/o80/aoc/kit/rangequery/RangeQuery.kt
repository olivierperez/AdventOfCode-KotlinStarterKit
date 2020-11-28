package fr.o80.aoc.kit.rangequery


/**
    ```
    val key = listOf(11, 22, 33, 44, 55)
    val mutations = listOf(1..3, 0..1, 2..2, 2..4)

    val rangeQuery = RangeQuery(
        key,
        applyMutation = { a, b -> a xor b },
        unapplyMutation = { b, a -> a xor b }
    )

    println(rangeQuery
        .compute(mutations)
        .joinToString()
    )
    ```
 */
class RangeQuery(
    key: List<Int>,
    private val applyMutation: (a: Int, b: Int) -> Int,
    private val unapplyMutation: (b: Int, a: Int) -> Int
) {

    private val memo: MutableMap<IntRange, Int> = mutableMapOf()
    private val preCalculatedMutations = preCalculate(key)

    fun compute(mutations: Iterable<IntRange>): List<Int> {
        return mutations
            .map { range -> compute(range, preCalculatedMutations) }
    }

    private fun preCalculate(key: List<Int>): List<Int> {
        return key.runningFold(0) { acc, elem -> applyMutation(acc, elem) }
    }

    private fun compute(range: IntRange, list: List<Int>): Int {
        if (memo.containsKey(range)) {
            return memo.getValue(range)
        }
        return unapplyMutation(list[range.last + 1], list[range.first])
            .also { result -> memo[range] = result }
    }

}