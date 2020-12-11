package fr.o80.aoc.kit

fun String.linesOfInt(): List<Int> = lines().map(String::toInt)
fun String.sequenceOfInt(): Sequence<Int> = lineSequence().map(String::toInt)

fun String.linesOfLong(): List<Long> = lines().map(String::toLong)
fun String.sequenceOfLong(): Sequence<Long> = lineSequence().map(String::toLong)
