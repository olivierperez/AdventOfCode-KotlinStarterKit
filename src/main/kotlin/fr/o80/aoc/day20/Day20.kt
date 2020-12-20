package fr.o80.aoc.day20

import fr.o80.aoc.kit.Vector2i
import fr.o80.aoc.kit.skip
import fr.o80.aoc.kit.table.Table

const val NORTH = 0
const val EAST = 1
const val SOUTH = 2
const val WEST = 3

val ness = listOf(
    //..................#.
    Vector2i(18, 0),
    //#....##....##....###
    Vector2i(0, 1),
    Vector2i(5, 1),
    Vector2i(6, 1),
    Vector2i(11, 1),
    Vector2i(12, 1),
    Vector2i(17, 1),
    Vector2i(18, 1),
    Vector2i(19, 1),
    //.#..#..#..#..#..#...
    Vector2i(1, 2),
    Vector2i(4, 2),
    Vector2i(7, 2),
    Vector2i(10, 2),
    Vector2i(13, 2),
    Vector2i(16, 2)
)

class Image(
    val id: Long,
    var map: Table<Char>,
    var neighbors: MutableMap<Int, Image> = mutableMapOf()
) {
    fun getBorder(i: Int): String {
        return when (i) {
            0 -> (0 until map.width).map { map[it, 0] }.joinToString("")
            1 -> (0 until map.height).map { map[map.width - 1, it] }.joinToString("")
            2 -> (0 until map.width).map { map[it, map.height - 1] }.joinToString("")
            3 -> (0 until map.height).map { map[0, it] }.joinToString("")
            else -> throw IllegalArgumentException("Border n$i unknown")
        }
    }

    fun hasBorder(border: String): Boolean {
        val borderReversed = border.reversed()
        return (0..3).map { getBorder(it) }.any { otherBorder ->
            otherBorder == border || otherBorder == borderReversed
        }
    }

    val north: Image? get() = neighbors[NORTH]
    val east: Image? get() = neighbors[EAST]
    val south: Image? get() = neighbors[SOUTH]
    val west: Image? get() = neighbors[WEST]

}

class Day20 {

    fun parse1(input: String): List<Image> {
        return input.split("\n\n").map { imageStr ->
            val lines = imageStr.lines()
            val mapLines = lines.skip(1)
            val id = lines[0].replace("[^0-9]".toRegex(), "").toLong()
            val map = Table<Char>(lines[1].length, lines.size - 1)

            mapLines.forEachIndexed { x, line ->
                line.forEachIndexed { y, char ->
                    map[y, x] = char
                }
            }

            Image(
                id = id,
                map = map
            )
        }
    }

    fun part1(images: List<Image>): Long {
        computeNeighbors(images)
        return images.filter { it.neighbors.size == 2 }.fold(1L) { acc, image -> acc * image.id }
    }

    private fun computeNeighbors(images: List<Image>) {
        for (image in images) {
            image.neighbors = (0..3).mapNotNull { borderIndex ->
                val border = image.getBorder(borderIndex)
                val potentialNeighbors = images.firstOrNull { otherImage ->
                    image != otherImage && otherImage.hasBorder(border)
                }

                potentialNeighbors
                    ?.let { Pair(borderIndex, potentialNeighbors) }
            }.toMap(mutableMapOf())
        }
    }

    fun parse2(input: String): List<Image> {
        return parse1(input)
    }

    fun part2(images: List<Image>): Int {
        computeNeighbors(images)
        adjustImages(images)
        cropImages(images)
        val fullImage: Table<Char> = assembleImages(images)

        val withNess = replaceNess(fullImage)

        withNess.forEachIndexed { x, _, c ->
            if (x == 0) println()
            if (c != null) {
                print(c)
            } else {
                print('?')
            }
        }

        return withNess.count { c -> c == '#' }
    }

    private fun replaceNess(fullImage: Table<Char>): Table<Char> {
        var image = fullImage
        repeat(4) {
            if (doReplace(image)) {
                return image
            }

            val hFlipped = image.horizontalFlip()
            if (doReplace(hFlipped)) {
                return hFlipped
            }

            val vFlipped = image.verticalFlip()
            if (doReplace(vFlipped)) {
                return vFlipped
            }

            val vhFlipped = vFlipped.horizontalFlip()
            if (doReplace(vhFlipped)) {
                return vhFlipped
            }

            image = image.clockwiseRotated()
        }

        /*
        xxxx    2860
        xxxx    2647
        xxxx    1153
         */

        /*
        xxxx    1171
        xxxx    2789
        xxxx    1163
         */

        /*
        xxxx    XXXX|1619
        xxxx    1601|
        xxxx    1619|3343
         */

        throw IllegalStateException("On a tout testé")
    }

    private fun doReplace(fullImage: Table<Char>): Boolean {
        var done = false
        for (x in 0 until fullImage.width - 20) {
            for (y in 0 until fullImage.height - 3) {
                if (ness.all { n -> fullImage[x + n.x, y + n.y] == '#' }) {
                    done = true
                    ness.forEach { n -> fullImage[x + n.x, y + n.y] = 'O' }
                }
            }
        }
        return done
    }

    private fun assembleImages(images: List<Image>): Table<Char> {
        val topLeftImage = images.firstOrNull { image -> 0 !in image.neighbors.keys && 3 !in image.neighbors.keys }
            ?: throw IllegalStateException("Je n'ai pas de pièce en haut à gauche !")

        val width = computeFullImageWidth(topLeftImage)
        val height = computeFullImageHeight(topLeftImage)

        val fullTable = Table<Char>(width, height)

        var y = 0
        var firstImageOnTheLeft: Image? = topLeftImage
        while (firstImageOnTheLeft != null) {
            fillFullTable(fullTable, firstImageOnTheLeft, y)
            y += 8
            firstImageOnTheLeft = firstImageOnTheLeft.south
        }

        return fullTable
    }

    private fun fillFullTable(fullTable: Table<Char>, leftImage: Image, yDelta: Int) {
        var x = 0
        var image: Image? = leftImage

        while (image != null) {
            fillFullTable(fullTable, image, x, yDelta)
            x += 8
            image = image.east
        }
    }

    private fun fillFullTable(fullTable: Table<Char>, image: Image, xDelta: Int, yDelta: Int) {
        for (x in 0 until 8)
            for (y in 0 until 8)
                fullTable[x + xDelta, y + yDelta] = image.map[x, y]!!
    }

    private fun computeFullImageWidth(topLeftImage: Image): Int {
        var width = 8
        var image = topLeftImage

        while (1 in image.neighbors.keys) {
            width += 8
            image = image.east!!
        }

        return width
    }

    private fun computeFullImageHeight(topLeftImage: Image): Int {
        var width = 8
        var image = topLeftImage

        while (2 in image.neighbors.keys) {
            width += 8
            image = image.south!!
        }

        return width
    }

    private fun cropImages(images: List<Image>) {
        images.forEach { image ->
            val cropped = Table<Char>(image.map.width - 2, image.map.height - 2)

            cropped.forEachIndexed { x, y, _ ->
                cropped[x, y] = image.map[x + 1, y + 1]!!
            }

            image.map = cropped
        }
    }

    private fun adjustImages(images: List<Image>) {
        val goods = mutableListOf<Long>()
        val todoImages = mutableListOf(images.first())

        while (todoImages.isNotEmpty()) {
            val imageWithWrongNeighbors = todoImages.removeAt(0)
            (0..3).forEach { borderIndex ->
                val neighborToAdjust = imageWithWrongNeighbors.neighbors[borderIndex]
                if (neighborToAdjust != null && neighborToAdjust.id !in goods && neighborToAdjust !in todoImages) {
//                    println("Adjust: ${neighborToAdjust.id}")
                    adjustImage(neighborToAdjust, borderIndex, imageWithWrongNeighbors.getBorder(borderIndex))

                    if (neighborToAdjust !in todoImages)
                        todoImages.add(neighborToAdjust)
                }
            }
            goods.add(imageWithWrongNeighbors.id)
        }
    }

    private fun adjustImage(neighborImage: Image, borderIndex: Int, border: String) {
        val neighborBorderIndex = findNeighborBorder(neighborImage, border)

        val expectedNeighborBorderIndex = (borderIndex + 2) % 4
        val rotations = (expectedNeighborBorderIndex - neighborBorderIndex + 4) % 4
        if (rotations != 0) {
            clockRotateImage(neighborImage, rotations)
        }

        val newNeighborBorderValue = neighborImage.getBorder(expectedNeighborBorderIndex)
        if (newNeighborBorderValue != border) {
            if (borderIndex == 0 || borderIndex == 2) {
                horizontalFlipImage(neighborImage)
            } else {
                verticalFlipImage(neighborImage)
            }
        }

    }

    private fun findNeighborBorder(image: Image, border: String): Int {
        return (0..3)
            .map { image.getBorder(it) }
            .indexOfFirst { it == border || it.reversed() == border }
    }

    private fun horizontalFlipImage(image: Image) {
        image.map = image.map.horizontalFlip()
        image.neighbors = mutableMapOf<Int, Image>().apply {
            image.north?.let { this[0] = it }
            image.west?.let { this[1] = it }
            image.south?.let { this[2] = it }
            image.east?.let { this[3] = it }
        }
    }

    private fun verticalFlipImage(image: Image) {
        image.map = image.map.verticalFlip()
        image.neighbors = mutableMapOf<Int, Image>().apply {
            image.south?.let { this[0] = it }
            image.east?.let { this[1] = it }
            image.north?.let { this[2] = it }
            image.west?.let { this[3] = it }
        }
    }

    private fun clockRotateImage(image: Image, rotations: Int) {
        repeat(rotations) {
            image.map = image.map.clockwiseRotated()
            image.neighbors = mutableMapOf<Int, Image>().apply {
                image.west?.let { this[0] = it }
                image.north?.let { this[1] = it }
                image.east?.let { this[2] = it }
                image.south?.let { this[3] = it }
            }
        }
    }

}
