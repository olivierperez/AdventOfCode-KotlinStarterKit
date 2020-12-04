package fr.o80.aoc.day04

class Day04 {

    fun simpleValidityCount(passports: List<Passport>): Int {
        return passports.count(::passportIsValid)
    }

    fun complexValidityCount(passports: List<Passport>): Int {
        return passports.count(::passportIsFullyValid)
    }

    private fun passportIsValid(passport: Passport): Boolean {
        return passport.countKeys() == 8 || passport.countKeys() == 7 && Key.COUNTRY_ID !in passport
    }

    private fun passportIsFullyValid(passport: Passport): Boolean {
        return passportIsValid(passport) && Key.values().all { key ->
            val value = passport[key]
            key.isValid(value)
        }
    }

}
