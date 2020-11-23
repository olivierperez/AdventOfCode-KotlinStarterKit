package fr.o80.aoc.kit

fun <T> Iterable<T>.show(): String = this.joinToString(",", prefix = "[", postfix = "]")

fun <T> Array<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index2]
    this[index2] = this[index1]
    this[index1] = tmp
}

fun <T> Array<T>.show(): String = this.joinToString(",", prefix = "[", postfix = "]")

fun IntArray.swap(index1: Int, index2: Int) {
    val tmp = this[index2]
    this[index2] = this[index1]
    this[index1] = tmp
}

fun IntArray.show(): String = this.joinToString(",", prefix = "[", postfix = "]")

fun LongArray.swap(index1: Int, index2: Int) {
    val tmp = this[index2]
    this[index2] = this[index1]
    this[index1] = tmp
}

fun LongArray.show(): String = this.joinToString(",", prefix = "[", postfix = "]")
