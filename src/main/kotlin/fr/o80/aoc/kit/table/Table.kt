package fr.o80.aoc.kit.table

class Table<T>(
    val width: Int,
    val height: Int,
    init: (index: Int) -> T? = { null }
) {

    private val data = MutableList(width * height, init)

    operator fun get(x: Int, y: Int): T? {
        checkBounds(x, y)
        return data[x + y * width]
    }

    operator fun set(x: Int, y: Int, value: T) {
        checkBounds(x, y)
        data[x + y * width] = value
    }

    fun debug(toString: (T?) -> String = { it.toString() }) {
        for (y in 0 until height) {
            for (x in 0 until width) {
                print(" " + toString(this[x, y]!!))
            }
            println()
        }
    }

    private fun checkBounds(x: Int, y: Int) {
        if (isOutOfBounds(x, y)) {
            throw IndexOutOfBoundsException("Cell [$x;$y] out of ($width, $height)")
        }
    }

    fun getOrNull(x: Int, y: Int): T? =
        if (isOutOfBounds(x, y)) null
        else data[x + y * width]

    private fun isOutOfBounds(x: Int, y: Int) =
        x < 0 || y < 0 || x >= width || y >= height

    fun count(predicate: (T?) -> Boolean): Int {
        return data.count(predicate)
    }

    fun forEachIndexed(block: (Int, Int, T?) -> Unit) {
        for (y in 0 until height) {
            for (x in 0 until width) {
                block(x, y, get(x, y))
            }
        }
    }

    fun clockwiseRotated(): Table<T> {
        val newTable = Table<T>(height, width)

        for (x in 0 until width) {
            for (y in 0 until height) {
                newTable[height - y - 1, x] = get(x, y)!!
            }
        }

        return newTable
    }

    fun horizontalFlip(): Table<T> {
        val newTable = Table<T>(width, height)

        for (x in 0 until width) {
            for (y in 0 until height) {
                newTable[x, y] = this[width - x - 1, y]!!
            }
        }

        return newTable
    }

    fun verticalFlip(): Table<T> {
        val newTable = Table<T>(width, height)

        for (x in 0 until width) {
            for (y in 0 until height) {
                newTable[x, y] = this[x, height - y - 1]!!
            }
        }

        return newTable
    }

}
