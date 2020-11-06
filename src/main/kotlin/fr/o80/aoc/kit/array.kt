package fr.o80.aoc.kit

// TODO Test
fun swap(input: IntArray, index1: Int, index2: Int) {
    val tmp = input[index2]
    input[index2] = input[index1]
    input[index1] = tmp
}
