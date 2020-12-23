package fr.o80.aoc.day23

class Circle<T> {

    private var current: Node<T>? = null

    private var first: Node<T>? = null
    private var last: Node<T>? = null

    private val insertions = mutableMapOf<T, List<T>>()

    var size: Int = 0
        private set

    fun add(value: T) {
        if (first == null) {
            first = Node(value)
            last = first
            last!!.next = first
        } else {
            val node = Node(value, first)
            last!!.next = node
            last = node
        }

        size++
    }

    /*fun addNext(value: T) {
        val wasLast = current == last
        val new = Node(value, current!!.next)
        current!!.next = new

        if (wasLast) {
            last = new
        }
    }*/

    private fun addNext(currentNode: Node<T>, a: T, b: T, c: T) {
        val wasLast = currentNode == last
        val nodeC = Node(c, currentNode!!.next)
        val nodeB = Node(b, nodeC)
        val nodeA = Node(a, nodeB)

        currentNode!!.next = nodeA

        if (wasLast) {
            last = nodeC
        }
    }

    fun next(): T {
        return if (current == null) {
            current = first
            current!!.value
        } else {
            current = current!!.next

            applyInsertionIfNeeded(current!!.value, current!!)

            current!!.value
        }
    }

    fun popNext(): T {
        return current!!.next!!.value
            .also { poped ->
                if (current!!.next == last) {
                    last = current
                }
                if (current!!.next == first) {
                    first = first!!.next
                }

                current!!.next = current!!.next!!.next

                applyInsertionIfNeeded(poped, current!!)

                size--
            }
    }

    fun addAllAfter(search: T, values: List<T>) {
        if (search in insertions) {
            throw IllegalStateException("Faut gérer des listes d'insertions mon poste !")
        }
        insertions[search] = values
        size += values.size
    }

    fun toList(): List<T> {
        var node = first!!
        val list = mutableListOf<T>()

        do {
            val value = node.value
            applyInsertionIfNeeded(value, node)

            list.add(value)
            node = node.next!!
        } while (node != first)

        return list
    }

    private fun applyInsertionIfNeeded(value: T, currentNode: Node<T>) {
        if (value in insertions) {
            val insertion = insertions.remove(value)!!
            addNext(currentNode, insertion[0], insertion[1], insertion[2])
        }
    }

    override fun toString(): String {
        return toList().toString()
    }
}

private class Node<T>(
    val value: T,
    var next: Node<T>? = null
)