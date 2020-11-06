package fr.o80.aoc.kit

data class Rectangle2f(val topLeft: Vector2f, val bottomRight: Vector2f) {
    // TODO Test
    operator fun contains(vector: Vector2f): Boolean {
        return (vector.x in topLeft.x..bottomRight.x) && (vector.y in topLeft.y..bottomRight.y)
    }
}

data class Rectangle2i(val topLeft: Vector2i, val bottomRight: Vector2i) {
    // TODO Test
    operator fun contains(vector: Vector2i): Boolean {
        return (vector.x in topLeft.x..bottomRight.x) && (vector.y in topLeft.y..bottomRight.y)
    }
}
