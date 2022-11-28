package fr.o80.aoc.kit.table

// TODO Unit tests

class Dimension3<T>(
    val size1: Int,
    val size2: Int,
    val size3: Int,
    val data: Array<Array<Array<T>>>
) {

    operator fun set(x: Int, y: Int, z: Int, value: T) {
        data[x][y][z] = value
    }

    operator fun get(x: Int, y: Int, z: Int): T {
        return data[x][y][z]
    }

    fun getOrNull(x: Int, y: Int, z: Int): T? {
        if (x < 0 || y < 0 || z < 0) {
            return null
        }
        if (x >= data.size || y >= data[0].size || z >= data[0][0].size) {
            return null
        }

        return data[x][y][z]
    }

    fun count(predicate: (T) -> Boolean): Int {
        return data.sumBy { a ->
            a.sumBy { b ->
                b.filter { c -> predicate(c) }.count()
            }
        }
    }

    companion object {
        inline fun <reified T> create(
            size1: Int,
            size2: Int,
            size3: Int,
            init: (Int, Int, Int) -> T
        ): Dimension3<T> {
            val data: Array<Array<Array<T>>> =
                Array(size1) { x ->
                    Array(size2) { y ->
                        Array(size3) { z ->
                            init(x, y, z)
                        }
                    }
                }
            return Dimension3(size1, size2, size3, data)
        }
    }
}
