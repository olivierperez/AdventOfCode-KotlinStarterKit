package fr.o80.aoc.kit

fun <E> List<E>.skip(i: Int): List<E> {
    return this.subList(i, this.size)
}
