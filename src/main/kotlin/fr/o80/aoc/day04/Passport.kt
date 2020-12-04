package fr.o80.aoc.day04

class Passport {

    private val info: MutableMap<Key, String> = mutableMapOf()

    operator fun set(key: Key, value: String) {
        info[key] = value
    }

    operator fun get(key: Key): String? {
        return info[key]
    }

    operator fun contains(key: Key): Boolean {
        return info.containsKey(key)
    }

    fun countKeys(): Int {
        return info.size
    }

}
