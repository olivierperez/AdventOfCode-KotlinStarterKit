package fr.o80.aoc.day01

data class ElfBackpack(
    val food: List<Int>
) {
    val totalCalories: Int get() = food.sum()
}

class Day01 {

    fun parse(input: String): List<ElfBackpack> {
        return input
            .split("\n\n")
            .map { elfInput ->
                elfInput.lines().map { it.toInt() }
            }
            .map(::ElfBackpack)
    }

    fun part1(elvesBackpack: List<ElfBackpack>): Int {
        return elvesBackpack
            .maxOf(ElfBackpack::totalCalories)
    }

    fun part2(elvesBackpack: List<ElfBackpack>): Int {
        return elvesBackpack
            .sortedByDescending(ElfBackpack::totalCalories)
            .take(3)
            .sumOf(ElfBackpack::totalCalories)
    }

}
