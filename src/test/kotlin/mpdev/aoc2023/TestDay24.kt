package mpdev.aoc2023

import mpdev.aoc2023.aoc.AoC
import mpdev.aoc2023.aoc.testMode
import mpdev.aoc2023.solutions.AoC2023Inputs
import mpdev.aoc2023.solutions.Day24
import mpdev.aoc2023.solutions.Day24.Companion.gridToString
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Nested
@DisplayName("Day 24 Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class TestDay24 {

    private val inputLines = File("src/test/resources/input24.txt").readLines()
    private lateinit var testPuzzle: Day24

    @BeforeEach
    fun testSetup() {
        testMode = true
        testPuzzle = AoC().processDayInput(AoC2023Inputs(), 24, inputLines) as Day24
    }

    @Test
    @Order(1)
    fun `Test Get Input`() {
        println(testPuzzle.grid.gridToString())
        testPuzzle.blizzardList.forEach { println(it) }
        assertEquals(6, testPuzzle.grid.size)
    }

    @Test
    @Order(3)
    fun `Test Blizzard Path Example`() {
        val inputLines = listOf(
            "#.#####",
            "#.....#",
            "#>....#",
            "#.....#",
            "#...v.#",
            "#.....#",
            "#####.#"
        )
        val testPuzzle = Day24(inputLines)
        println(testPuzzle.grid.gridToString())
        println(testPuzzle.blizzardList)
        (0..5).forEach {
            println("$it.")
            testPuzzle.overlay(it)
            println(testPuzzle.overlayGrid.gridToString())
        }
    }

    @Test
    @Order(10)
    fun `Test Calculate Part 1`() {
        val expected = "18"
        val result = testPuzzle.part1()
        println("Start")
        testPuzzle.overlay(0)
        println(testPuzzle.overlayGrid.gridToString())
        println("Finish")
        testPuzzle.overlay(18)
        println(testPuzzle.overlayGrid.gridToString())
        println("result $result")
        assertEquals(expected, result)
    }

    @Test
    @Order(12)
    fun `Test Calculate Part 2`() {
        val expected = "54"
        val result = testPuzzle.part2()
        println("result $result")
        assertEquals(expected, result)
    }

}

