package mpdev.aoc2023.solutions

import mpdev.aoc2023.aoc.AoCDay
import mpdev.aoc2023.aoc.AoCInput

@AoCInput
class AoC2023Inputs {

    @AoCDay(day = 1)
    fun day1(input: List<String>): Day1 {
        return Day1()
    }

    @AoCDay(day = 2)
    fun day2(input: List<String>): Day2 {
        return Day2()
    }
}