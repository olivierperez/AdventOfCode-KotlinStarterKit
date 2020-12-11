package fr.o80.aoc.kit.rangequery


/**
    ```
    val key = listOf(11, 22, 33, 44, 55)
    val mutations = listOf(1..3, 0..1, 2..2, 2..4)

    val rangeQuery = RangeQuery(
        key,
        applyMutation = { a, b -> a + b },
        unapplyMutation = { a, b -> b - a }
    )

    println(rangeQuery
        .compute(mutations)
        .joinToString()
    )
    ```
 */
class RangeQuery<T: Comparable<T>>(
    key: List<T>,
    private val initial: T,
    private val applyMutation: (a: T, b: T) -> T,
    private val unapplyMutation: (a: T, b: T) -> T
) {

    private val memo: MutableMap<IntRange, T> = mutableMapOf()

    val preCalculatedMutations: List<T> = preCalculate(key)

    fun compute(range: IntRange): T {
        return compute(range, preCalculatedMutations)
    }

    fun compute(mutations: Iterable<IntRange>): List<T> {
        return mutations
            .map { range -> compute(range, preCalculatedMutations) }
    }

    private fun preCalculate(key: List<T>): List<T> {
        return key.runningFold(initial) { acc, elem -> applyMutation(acc, elem) }
    }

    private fun compute(range: IntRange, list: List<T>): T {
        if (memo.containsKey(range)) {
            return memo.getValue(range)
        }
        return unapplyMutation(list[range.first], list[range.last + 1])
            .also { result -> memo[range] = result }
    }

}