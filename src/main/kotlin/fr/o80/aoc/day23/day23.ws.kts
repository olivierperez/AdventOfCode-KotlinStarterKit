import fr.o80.aoc.day23.Circle
import java.util.*

println("example => ${0 + 0}")

val mutList = mutableListOf(1, 2, 3)
mutList.add(mutList.indexOf(1) + 1, 99)
mutList


val linkedList = LinkedList<Int>().apply {
    add(1)
    add(2)
    add(3)
    add(4)
}
val iterator1 = linkedList.iterator()
iterator1.next()
iterator1.next()
iterator1.next()


val iterator2 = linkedList.iterator()
iterator2.next()

val circle = Circle<Int>()
circle.add(1)
circle.add(2)
circle.add(3)
circle.add(4)

circle.addAllAfter(3, listOf(90,91,92))