package fr.o80.aoc.day04

enum class Key(val value: String, val validator: Validator) {
    BIRTH_YEAR("byr", IntValidator { it in 1920..2002 }),
    ISSUE_YEAR("iyr", IntValidator { it in 2010..2020 }),
    EXPIRATION_YEAR("eyr", IntValidator { it in 2020..2030 }),
    HEIGHT("hgt", RegexValidator("^(\\d+)(cm|in)\$") { matchResult ->
        val size = matchResult.groupValues[1].toInt()
        when (val unity = matchResult.groupValues[2]) {
            "cm" -> size in 150..193
            "in" -> size in 59..76
            else -> throw IllegalArgumentException("ton unité $unity je ne sais quoi en faire")
        }
    }),
    HAIR_COLOR("hcl", RegexValidator("^#[0-9a-fA-F]{6}$")),
    EYE_COLO("ecl", EnumValidator(arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth"))),
    PASSPORT_ID("pid", RegexValidator("^\\d{9}$")),
    COUNTRY_ID("cid", WhateverValidator);

    fun isValid(value: String?): Boolean =
        validator.isValid(value)

    companion object {
        fun from(value: String): Key? {
            return values().firstOrNull { it.value == value }
        }
    }
}