package mpdev.aoc2023

import mpdev.aoc2023.aoc.AoC
import mpdev.aoc2023.solutions.AoC2023Inputs
import mpdev.aoc2023.solutions.Day1
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Nested
@DisplayName("Day 1 Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class TestDay1 {

    private val inputLines = File("src/test/resources/input01.txt").readLines()

    /*
    The first Elf is carrying food with 1000, 2000, and 3000 Calories, a total of 6000 Calories.
    The second Elf is carrying one food item with 4000 Calories.
    The third Elf is carrying food with 5000 and 6000 Calories, a total of 11000 Calories.
    The fourth Elf is carrying food with 7000, 8000, and 9000 Calories, a total of 24000 Calories.
    The fifth Elf is carrying one food item with 10000 Calories.
    */

    @Test
    @Order(1)
    fun `Test Get Input`() {
        val expected = listOf(
            Day1.Elf(0, 1000),
            Day1.Elf(0, 2000),
            Day1.Elf(0, 3000),
            Day1.Elf(1, 4000),
            Day1.Elf(2, 5000),
            Day1.Elf(2, 6000),
            Day1.Elf(3, 7000),
            Day1.Elf(3, 8000),
            Day1.Elf(3, 9000),
            Day1.Elf(4, 10000)
        )
        val puzzle = AoC().processDayInput(AoC2023Inputs(), 1, inputLines) as Day1
        println(puzzle.dataList)
        assertEquals(expected.size, puzzle.dataList.size)
        for (i in puzzle.dataList.indices)
            assertEquals(expected[i], puzzle.dataList[i])
    }

    @Test
    @Order(2)
    fun `Test Calculate Part 1`() {
        val expected = 24000
        val puzzle = AoC().processDayInput(AoC2023Inputs(), 1, inputLines) as Day1
        assertEquals(expected.toString(), puzzle.part1())
    }

    @Test
    @Order(3)
    fun `Test Calculate Part 2`() {
        val expected = 45000
        val puzzle = AoC().processDayInput(AoC2023Inputs(), 1, inputLines) as Day1
        assertEquals(expected.toString(), puzzle.part2())
    }
}

