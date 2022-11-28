package fr.o80.aoc.kit.table

// TODO Test

class TableParser {
    fun <T> parse(input: String, transform: (Char) -> T) : Table<T> {
        val lines = input.lines()
        val height = lines.size
        val width = lines[0].length

        val table = Table<T>(width, height)

        lines.forEachIndexed { y, line ->
            line.forEachIndexed { x, char ->
                val value = transform(char)
                table[x, y] = value
            }
        }

        return table
    }
}
