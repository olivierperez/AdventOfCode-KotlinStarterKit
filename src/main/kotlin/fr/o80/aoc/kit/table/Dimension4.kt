package fr.o80.aoc.kit.table

// TODO Unit tests

class Dimension4<T>(
    val size1: Int,
    val size2: Int,
    val size3: Int,
    val size4: Int,
    val data: Array<Array<Array<Array<T>>>>
) {

    operator fun set(w: Int, x: Int, y: Int, z: Int, value: T) {
        data[w][x][y][z] = value
    }

    operator fun get(w: Int, x: Int, y: Int, z: Int): T {
        return data[w][x][y][z]
    }

    fun getOrNull(w: Int, x: Int, y: Int, z: Int): T? {
        if (w < 0 || x < 0 || y < 0 || z < 0) {
            return null
        }
        if (w >= data.size || x >= data[0].size || y >= data[0][0].size || z >= data[0][0][0].size) {
            return null
        }

        return data[w][x][y][z]
    }

    fun count(predicate: (T) -> Boolean): Int {
        return data.sumBy { a ->
            a.sumBy { b ->
                b.sumBy { c ->
                    c.filter { d -> predicate(d) }.count()
                }
            }
        }
    }

    companion object {
        inline fun <reified T> create(
            size1: Int,
            size2: Int,
            size3: Int,
            size4: Int,
            init: (Int, Int, Int, Int) -> T
        ): Dimension4<T> {
            val data: Array<Array<Array<Array<T>>>> =
                Array(size1) { w ->
                    Array(size2) { x ->
                        Array(size3) { y ->
                            Array(size4) { z ->
                                init(w, x, y, z)
                            }
                        }
                    }
                }
            return Dimension4(size1, size2, size3, size4, data)
        }
    }
}
