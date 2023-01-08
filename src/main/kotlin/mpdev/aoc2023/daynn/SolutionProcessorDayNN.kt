package mpdev.aoc2023.daynn

import mpdev.aoc2023.common.*
import kotlin.system.measureTimeMillis

class SolutionProcessorDayNN: SolutionProcessor<DayNN> {

    override val date: String = "01.12.2023"

    /** part 1 calculation */
    override fun part1(puzzle: DayNN): Pair<String,Long> {
        val res: Int
        val elapsed = measureTimeMillis { res = 0 }
        return Pair(res.toString(),elapsed)
    }

    /** part 2 calculation */
    override fun part2(puzzle: DayNN): Pair<String,Long> {
        val res: Int
        val elapsed = measureTimeMillis { res = 0 }
        return Pair(res.toString(),elapsed)
    }

}