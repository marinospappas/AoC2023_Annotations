package mpdev.aoc2023.common

import java.io.File

class PuzzleProcessor<P> (var part: Int,
                          var day: Int,
                          var inputProcessor: InputProcessor<P>,
                          var solutionProcessor: SolutionProcessor<P>) {
    fun process() {
        println("${Constants.AOC} - Day $day, ${Constants.AUTHOR} - ${solutionProcessor.date}")
        val inputLines = File("src/main/resources/day${String.format("%02d", day)}/input.txt").readLines()
        val puzzle = inputProcessor.process(inputLines)
        if (part in (0..1)) {
            print("Part 1: ")
            val (result, elapsed) = solutionProcessor.part1(puzzle)
            println("result $result, $elapsed msec\n")
        }
        if (part == 0 || part == 2) {
            print("Part 2: ")
            val (result, elapsed) = solutionProcessor.part2(puzzle)
            println("result $result, $elapsed msec\n")
        }
    }
}

