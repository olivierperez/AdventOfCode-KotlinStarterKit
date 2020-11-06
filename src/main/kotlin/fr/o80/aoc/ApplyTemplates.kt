package fr.o80.aoc

import java.io.File

fun main() {
    for (i in 1..24) {
        generateCode(i.toString())
        generateUnitTest(i.toString())
    }
}

fun generateCode(day1digit: String) {
    val day2digits = day1digit.padStart(2, '0')
    val dayDir = File("src/main/kotlin/fr/o80/aoc/day$day2digits")
    val templateDir = File("template/code")

    dayDir.deleteRecursively()
    dayDir.mkdirs()

    copyTemplate(templateDir, "", "DayXX.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "", "dayXX.ws.kts", day1digit, day2digits, dayDir)
}

fun generateUnitTest(day1digit: String) {
    val day2digits = day1digit.padStart(2, '0')
    val dayDir = File("src/test/kotlin/fr/o80/aoc/day$day2digits")
    val templateDir = File("template/unittest")

    dayDir.deleteRecursively()
    File(dayDir, "part1").mkdirs()
    File(dayDir, "part2").mkdirs()

    copyTemplate(templateDir, "part1", "DayXXPart1UnitTest.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part1", "exercise.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part1", "input1.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part1", "input2.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part1", "input3.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part2", "DayXXPart2UnitTest.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part2", "exercise.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part2", "input1.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part2", "input2.kt", day1digit, day2digits, dayDir)
    copyTemplate(templateDir, "part2", "input3.kt", day1digit, day2digits, dayDir)
}

private fun copyTemplate(
    templateDir: File,
    partName: String,
    fileName: String,
    day1digit: String,
    day2digits: String,
    dayDir: File
) {
    val content = File(templateDir, "$partName/$fileName")
        .readText()

    val newContent = content
        .replace("{d1}", day1digit)
        .replace("{d2}", day2digits)

    File(dayDir, "$partName/${fileName.replace("XX", day2digits)}")
        .writeText(newContent)
}
