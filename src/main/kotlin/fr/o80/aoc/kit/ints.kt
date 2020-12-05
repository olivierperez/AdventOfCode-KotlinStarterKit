package fr.o80.aoc.kit

fun <T: Comparable<T>>Iterable<T>.minAndMaxOrNull(): Pair<T, T>? {
    return this.iterator().minAndMaxOrNull()
}

fun <T: Comparable<T>> Sequence<T>.minAndMaxOrNull(): Pair<T, T>? {
    return this.iterator().minAndMaxOrNull()
}

fun <T: Comparable<T>> Iterator<T>.minAndMaxOrNull(): Pair<T, T>? {
    var min: T? = null
    var max: T? = null

    this.forEach {
        if (min == null || it < min!!) {
            min = it
        }
        if (max == null || it > max!!) {
            max = it
        }
    }

    return if (min == null) {
        null
    } else {
        Pair(min!!, max!!)
    }
}
