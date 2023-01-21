package mpdev.aoc2023.solutions

import mpdev.aoc2023.aoc.AoCDay
import mpdev.aoc2023.aoc.AoCSolution

@AoCSolution
class AoC2023Solutions {

    @AoCDay(day = 1)
    fun day1(puzzle: Day1) {
        println(puzzle.msg)
        println("Part 1: ${puzzle.part1()} (${puzzle.part1Elapsed} msec)")
        println("Part 2: ${puzzle.part2()} (${puzzle.part2Elapsed} msec)")
    }

    @AoCDay(day = 2)
    fun day2(puzzle: Day2) {
        println(puzzle.msg)
    }
}