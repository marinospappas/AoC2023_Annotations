package mpdev.aoc2023.utils

import java.awt.Point
import java.lang.StringBuilder
import kotlin.math.abs

/** String class extensions */
var regexMatch: MatchResult? = null
fun String.matchRegExp(regex: Regex) = regex.find(this).also { regexMatch = it } != null

fun String.allCharsDifferent(): Boolean {
    for (i in 0..this.length-2)
        if (this.substring(i+1, this.length).contains(this[i]))
            return false
    return true
}


/** Pair class extensions */
operator fun Pair<Int,Int>.minus(b: Pair<Int,Int>): Pair<Int, Int> {
    return Pair(this.first - b.first, this.second - b.second)
}

operator fun Pair<Int,Int>.plus(b: Pair<Int,Int>): Pair<Int, Int> {
    return Pair(this.first + b.first, this.second + b.second)
}

fun Pair<Int,Int>.isAdjacent(b: Pair<Int,Int>): Boolean {
    return abs(this.first - b.first) in (0..1) &&
            abs(this.second - b.second) in (0..1)
}

/** List extensions */
fun List<*>.convertToString(): String
        = StringBuilder().also { s-> (0 until this.size).forEach { s.append("${this[it]}\n") } }.toString()

/** IntRange extensions */
fun IntRange.append(b: IntRange): IntRange? {
    return if (b.first > this.last+1)
        null
    else
        IntRange(this.first, if (this.last > b.last) this.last else b.last)
}

/** Point extensions */
operator fun Point.plus(b: Point) = Point(this.x+b.x, this.y+b.y)

fun Point.xPlus(n: Int) = Point(this.x+n, this.y)

fun Point.yPlus(n: Int) = Point(this.x, this.y+n)