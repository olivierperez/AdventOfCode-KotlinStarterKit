package fr.o80.aoc.day04

interface Validator {
    fun isValid(value: String?): Boolean
}

class IntValidator(private val validate: (Int?) -> Boolean) : Validator {
    override fun isValid(value: String?): Boolean {
        return validate(value?.toIntOrNull())
    }
}

object WhateverValidator : Validator {
    override fun isValid(value: String?): Boolean = true
}

class EnumValidator(private val allowedValues: Array<String>) : Validator {
    override fun isValid(value: String?): Boolean {
        return value in allowedValues
    }
}

class RegexValidator(
    private val regex: Regex,
    private val validate: (MatchResult) -> Boolean = { true }
) : Validator {

    constructor(
        regex: String,
        validate: (MatchResult) -> Boolean = { true }
    ) : this(regex.toRegex(), validate)

    override fun isValid(value: String?): Boolean {
        value ?: return false
        return regex.matchEntire(value)
            ?.let { matchResult -> validate(matchResult) }
            ?: false
    }
}
