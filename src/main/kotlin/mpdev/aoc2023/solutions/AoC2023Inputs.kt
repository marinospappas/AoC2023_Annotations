package mpdev.aoc2023.solutions

import mpdev.aoc2023.aoc.AoCDay
import mpdev.aoc2023.aoc.AoCInput

@AoCInput
class AoC2023Inputs {

    @AoCDay(day = 1)
    fun day1(input: List<String>): Day01 {
        val puzzle = Day01()
        var elfId = 0
        input.forEach {
            if (it.isNotEmpty())
                puzzle.dataList.add(Day01.Elf(elfId, it.toInt()))
            else
                ++elfId
        }
        return puzzle
    }

    @AoCDay(day = 24)
    fun day23(input: List<String>) = Day24(input)
}