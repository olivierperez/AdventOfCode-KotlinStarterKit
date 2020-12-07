package fr.o80.aoc.day07

class BagColor(val count: Int, val name: String) {

    val isShinyGold: Boolean
        get() = this.name == "shiny gold"

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return other is BagColor && name == other.name
    }
}
