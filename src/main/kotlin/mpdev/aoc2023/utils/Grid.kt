package mpdev.aoc2023.utils

import java.lang.StringBuilder

/** grid class - used only for visualisation */
class Grid(rope: MutableList<Pair<Int,Int>> = mutableListOf(Pair(0,0)), mode: Char = 'r' ) {

    private var dimensions = Pair(6,5)  // X, Y
    private val gridData = mutableListOf<MutableList<Char>>()
    private val trail = mutableListOf<Pair<Int,Int>>()
    private var shift = Pair(0,0)
    private var start = Pair(0,0)

    init {
        val minCoord = Pair((rope+start).minOf { it.first }, (rope+start).minOf { it.second })
        val maxCoord = Pair((rope+start).maxOf { it.first }, (rope+start).maxOf { it.second })
        dimensions = Pair(maxCoord.first-minCoord.first+2, maxCoord.second- minCoord.second+2)
        shift = Pair(-minCoord.first, -minCoord.second )
        start = start.plus(shift)
        rope.forEach { trail.add(it.plus(shift)) }
        // grid data
        (dimensions.second-1 downTo 0).forEach { y ->
            mutableListOf<Char>().also {
                (0 until dimensions.first).forEach { x ->
                    if (mode == 'r')    // rope
                        when {
                            (Pair(x, y) == trail[0]) -> it.add('H')
                            trail.indexOf(Pair(x, y)) >= 0 -> it.add((trail.indexOf(Pair(x, y))%10).toString().first())
                            Pair(x, y) == start -> it.add('s')
                            else -> it.add('.')
                        }
                    else                // trail
                        when {
                            Pair(x, y) == start -> it.add('s')
                            trail.indexOf(Pair(x, y)) >= 0 -> it.add('#')
                            else -> it.add('.')
                        }
                }
                gridData.add(it)
            }
        }
    }
    override fun toString() =
        StringBuilder().also { s -> gridData.forEach { s.append(it.joinToString("")).append("\n") } }.toString()
}
