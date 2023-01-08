package mpdev.aoc2023.utils

import java.awt.Point
import kotlin.math.abs

fun manhattanDist(p1: Point, p2: Point) =
    abs(p1.x-p2.x) + abs(p1.y-p2.y)