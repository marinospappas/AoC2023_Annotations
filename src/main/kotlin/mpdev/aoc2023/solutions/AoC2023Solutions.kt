package mpdev.aoc2023.solutions

import mpdev.aoc2023.aoc.AoCDay
import mpdev.aoc2023.aoc.AoCSolution

@AoCSolution
class AoC2023Solutions {

    @AoCDay(day = 1)
    fun day1(puzzle: Day01) {
        println(puzzle.msg)
        println("Part 1: ${puzzle.part1()} (${puzzle.elapsed1} msec)")
        println("Part 2: ${puzzle.part2()} (${puzzle.elapsed2} msec)")
    }

    @AoCDay(day = 24)
    fun day24(puzzle: Day24) {
        println("Part 1: ${puzzle.part1()} (${puzzle.elapsed1} msec)")
        println("Part 2: ${puzzle.part2()} (${puzzle.elapsed2} msec)")
    }
}