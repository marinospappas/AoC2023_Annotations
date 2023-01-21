package mpdev.aoc2023.day24

import mpdev.aoc2023.common.*
import mpdev.aoc2023.day24.Day24_.Companion.end
import mpdev.aoc2023.day24.Day24_.Companion.start
import mpdev.aoc2023.day24.Day24_.NodeId
import kotlin.system.measureTimeMillis

class SolutionProcessorDay24: SolutionProcessor<Day24_> {

    override val date: String = "07.01.2023"

    /** part 1 calculation */
    override fun part1(puzzle: Day24_): Pair<String,Long> {
        val res: Int
        val elapsed = measureTimeMillis { res = puzzle.findPath(NodeId(start,0), NodeId(end,-1)) }
        println("number of iterations: ${puzzle.iterCount}")
        return Pair(res.toString(),elapsed)
    }

    /** part 2 calculation */
    override fun part2(puzzle: Day24_): Pair<String,Long> {
        var res: Int
        var elapsed = measureTimeMillis { res = puzzle.findPath(NodeId(start,0), NodeId(end,-1)) }
        println("\n\tres1 $res, number of iterations: ${puzzle.iterCount}")
        elapsed += measureTimeMillis { res = puzzle.findPath(NodeId(end, res), NodeId(start,-1)) }
        println("\tres2 $res, number of iterations: ${puzzle.iterCount}")
        elapsed += measureTimeMillis { res = puzzle.findPath(NodeId(start, res), NodeId(end, -1)) }
        println("\tres3 $res, number of iterations: ${puzzle.iterCount}")
        return Pair(res.toString(),elapsed)
    }

}