println("example => ${0 + 0}")

val regex = "(?:\\d+ ([a-z ]+) bag)".toRegex()
val test = "5 aze bags, 1 rrr bag, 9 toto bags."


regex.findAll(test).count()
regex.findAll(test)
    .forEach {
        println("->" + it.groupValues[1])
    }