package fr.o80.aoc.kit

class Table<T>(
    val width: Int,
    val height: Int
) {

    private val data = MutableList<T?>(width * height) { null }

    operator fun get(x: Int, y: Int): T? {
        checkBounds(x, y)
        return data[x + y * width]
    }

    operator fun set(x: Int, y: Int, value: T) {
        checkBounds(x, y)
        data[x + y * width] = value
    }

    fun debug() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                print(" " + this[x, y]!!)
            }
            println()
        }
    }

    private fun checkBounds(x: Int, y: Int) {
        if (x < 0 || y < 0 || x > width - 1 || y > height - 1) {
            throw IndexOutOfBoundsException("Cell [$x;$y] out of ($width, $height)")
        }
    }

}
