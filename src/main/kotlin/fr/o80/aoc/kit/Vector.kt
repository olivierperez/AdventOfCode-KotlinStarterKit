package fr.o80.aoc.kit

data class Vector2f(val x: Float, val y: Float) {
    // TODO Test
    operator fun minus(other: Vector2f) : Vector2f = Vector2f(x - other.x, y - other.y)
    operator fun plus(other: Vector2f) : Vector2f = Vector2f(x + other.x, y + other.y)
}

data class Vector2i(val x: Int, val y: Int) {
    // TODO Test
    operator fun minus(other: Vector2i) : Vector2i = Vector2i(x - other.x, y - other.y)
    operator fun plus(other: Vector2i) : Vector2i = Vector2i(x + other.x, y + other.y)
}

data class Vector3f(val x: Float, val y: Float, val z: Float) {
    // TODO Test
    operator fun minus(other: Vector3f) : Vector3f = Vector3f(x - other.x, y - other.y, z - other.z)
    operator fun plus(other: Vector3f) : Vector3f = Vector3f(x + other.x, y + other.y, z + other.z)
}

data class Vector3i(val x: Int, val y: Int, val z: Float) {
    // TODO Test
    operator fun minus(other: Vector3i) : Vector3i = Vector3i(x - other.x, y - other.y, z - other.z)
    operator fun plus(other: Vector3i) : Vector3i = Vector3i(x + other.x, y + other.y, z + other.z)
}
