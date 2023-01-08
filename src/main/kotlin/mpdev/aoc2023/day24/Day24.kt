package mpdev.aoc2023.day24

import mpdev.aoc2023.common.RunTimeException
import mpdev.aoc2023.utils.manhattanDist
import mpdev.aoc2023.utils.plus
import java.awt.Point
import java.lang.StringBuilder
import java.util.*

class Day24(var inputList: List<String>) {

    companion object {
        lateinit var grid: Array<CharArray>
        lateinit var dimensions: Point
        lateinit var overlayGrid: Array<CharArray>
        lateinit var start: Point
        lateinit var end: Point
    }
    val blizzardList = mutableListOf<Blizzard>()
    private val blizzardStates = mutableListOf<List<Blizzard>>()
    // keep only the coords of the blizzards on each minute for efficiency
    private val blizzardListsOfPoints = mutableListOf<List<Point>>()
    var iterCount = 0

    init {
        dimensions = Point(inputList.first().length, inputList.size)
        grid =  Array(dimensions.y) { inputList[it].toCharArray() }
        grid.indices.forEach { y -> grid[y].indices.forEach { x ->   // keep blizzards in a separate list
                if ("^>v<".contains(grid[y][x])) {
                    blizzardList.add(Blizzard(Point(x,y), grid[y][x]))
                    grid[y][x] = '.'
                }
            }
        }
        start = Point(grid.first().indexOfFirst { it == '.' }, 0)
        end = Point(grid.last().indexOfFirst { it == '.' }, dimensions.y-1)
        // preprocess blizzards for the next n minutes
        processBlizzards(1000)
    }

    fun findPath(start: NodeId, end: NodeId): Int {
        iterCount = 0
        val queue = PriorityQueue(compareBy(NodeWithCost::cost))
        val seen = mutableSetOf(start)
        queue.add(NodeWithCost(start, start.blizIndx))
        while (!queue.isEmpty()) {
            ++iterCount
            val current = queue.poll()
            if (current.nodeId.pos == end.pos)
                return current.cost
            getFreeConnectedNodes(current.nodeId, start, end).forEach { node ->
                if (seen.add(node))
                    queue.add(NodeWithCost(node, node.blizIndx + manhattanDist(node.pos, end.pos)))
            }
        }
        throw RunTimeException("could not find path from $start to $end")
    }

    // connected nodes are calculated dynamically depending on the state of the blizzards
    private fun getFreeConnectedNodes(nodeId: NodeId, startId: NodeId, endId: NodeId): List<NodeId> {
        // list of neighbour points - also possible to stay in the same position if no blizzard in the next minute
        val connectedNodes = mutableListOf<NodeId>()
        listOf(Point(0,0), Point(-1,0), Point(+1,0), Point(0,-1), Point(0,+1)).forEach { point ->
            val neighbour = nodeId.pos + point
            if (neighbour == endId.pos)
                return listOf(NodeId(endId.pos, nodeId.blizIndx + 1))
            if (neighbour == startId.pos
                || (neighbour.x > 0 && neighbour.x < grid[0].lastIndex
                && neighbour.y > 0 && neighbour.y < grid.lastIndex))
                    connectedNodes.add(NodeId(neighbour, nodeId.blizIndx+1))
        }
        return connectedNodes.filterNot { blizzardListsOfPoints[nodeId.blizIndx+1].contains(it.pos) }
        // Improvement: instead of checking against the list of blizzard points which is costly
        // calculate the positions of the blizzards for each given minute by using the pattern:
        //     the blizzards repeat every "least common multiple" of rows-2, columns-2 minutes
    }

    fun overlay(blizIndx: Int) {
        overlayGrid = Array(dimensions.y) { y-> CharArray(dimensions.x) { x-> grid[y][x] } }
        blizzardStates[blizIndx].forEach {
            overlayGrid[it.pos.y][it.pos.x] = if (overlayGrid[it.pos.y][it.pos.x] == '.') it.direction else '2'
        }
    }

    private fun processBlizzards(repeat: Int) {
        blizzardStates.add(blizzardList)
        (1 until repeat).forEach { _ ->
            val newState = mutableListOf<Blizzard>()
            blizzardStates.last().forEach {
                newState.add(Blizzard(Point(it.pos.x,it.pos.y), it.direction))
                newState.last().moveToNewPos()
            }
            blizzardStates.add(newState)
        }
        blizzardStates.forEach { blizzards -> blizzardListsOfPoints.add(blizzards.map { it.pos }) }
    }

    data class Blizzard(var pos: Point, val direction: Char) {
        fun moveToNewPos() {
            when (direction) {
                '>' -> pos = Point(if (pos.x+1 == dimensions.x-1) 1 else pos.x + 1, pos.y)
                'v' -> pos = Point(pos.x, if (pos.y+1 == dimensions.y-1) 1 else pos.y + 1 )
                '<' -> pos = Point(if (pos.x-1 == 0) dimensions.x - 2 else pos.x - 1, pos.y)
                '^' -> pos = Point(pos.x, if (pos.y-1 == 0) dimensions.y - 2 else pos.y - 1 )
            }
        }
    }

    data class NodeId(val pos: Point, val blizIndx: Int)
    data class NodeWithCost(val nodeId: NodeId, val cost: Int)
}

fun Array<CharArray>.gridToString(): String {
    val s = StringBuilder()
    for (i in this.indices) {
        this[i].toList().forEach { s.append(it) }
        s.append("\n")
    }
    return s.toString()
}