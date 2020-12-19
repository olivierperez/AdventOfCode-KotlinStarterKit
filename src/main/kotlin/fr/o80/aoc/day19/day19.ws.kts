import java.util.regex.Pattern

println("example => ${0 + 0}")

val r3: String get() = "b"
val r2: String get() = "($r1$r3|$r3$r1)"
val r1: String get() = "a"
val r0: String get() = "$r1$r2"

r0
val regex = "^$r0$".toRegex()

regex.matches("aba")
regex.matches("aab")

regex.matches("a")
regex.matches("ab")
regex.matches("ba")

regex.matches("aabb")

/*println("== [^x] ==")
Regex("q[^u](p)").run {
    println(matches("qup"))
    println(matches("qp"))
    println(matches("qap"))
    println(find("qap")!!.groupValues)
}

println("== (?!x) ==")
Regex("q(?!u)(p)").run {
    println(matches("qu"))
    println(matches("qap"))
    println(matches("qp"))
    println(find("qp")!!.groupValues)
}

println("== (?=x) ==")
Regex("q(?=un)(.+)").run {
    println(matches("qp"))
    println(matches("qlol"))
    println(find("qunique")!!.groupValues)
}

println("== (ab|aa)\\1 ==")
Regex("""(ab|aa)\1""").run {
    println("abab: " + matches("abab"))
    println("aaaa: " + matches("aaaa"))
    println("abaa: " + matches("abaa"))
}*/

println("== full ==")
Regex("[ac](?:(?:(?:ac)(?=(?:ac)*(\\1?+(?:b))))+\\1)").run {
    println("cacacbb: " + find("cacacbb")!!.groupValues)
    println("cacacacbbb: " + find("cacacacbbb")!!.groupValues)
    println("cacacacbbb: " + find("cacacacbbb")!!.groupValues)
    println("caacacbb: " + matches("caacacbb"))
    println("cacacbbb: " + matches("cacacbbb"))
    println("cacacrbb: " + matches("cacacrbb"))
}
