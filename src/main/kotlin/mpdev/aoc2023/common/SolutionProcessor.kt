package mpdev.aoc2023.common

interface SolutionProcessor<P> {

    val date: String

    /** part 1 calculation */
    fun part1(puzzle: P): Pair<String,Long>

    /** part 2 calculation */
    fun part2(puzzle: P): Pair<String,Long>
}
