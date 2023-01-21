package mpdev.aoc2023.solutions

import mpdev.aoc2023.aoc.AoCDay
import mpdev.aoc2023.aoc.AoCInput

@AoCInput
class AoC2023Inputs {

    @AoCDay(day = 1)
    fun day1(input: List<String>): Day1 {
        val puzzle = Day1()
        var elfId = 0
        input.forEach {
            if (it.isNotEmpty())
                puzzle.dataList.add(Day1.Elf(elfId, it.toInt()))
            else
                ++elfId
        }
        return puzzle
    }

    @AoCDay(day = 2)
    fun day2(input: List<String>): Day2 {
        return Day2()
    }
}