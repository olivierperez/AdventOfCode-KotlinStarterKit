package fr.o80.aoc.kit.math

// TODO Unit tests

@Deprecated(message = "PPCM is the french version of LCM", replaceWith = ReplaceWith("lcm(n1, n2)"))
fun ppcm(n1: Int, n2: Int): Int {
    return lcm(n1, n2)
}

fun lcm(n1: Int, n2: Int): Int {
    var gcd = 1

    var i = 1
    while (i <= n1 && i <= n2) {
        // Checks if "i" is factor of both integers
        if (n1 % i == 0 && n2 % i == 0)
            gcd = i
        ++i
    }

    return n1 * n2 / gcd
}
