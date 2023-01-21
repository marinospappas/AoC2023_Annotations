package mpdev.aoc2023.day24

import mpdev.aoc2023.common.testMode
import mpdev.aoc2023.day24.Day24_.Companion.grid
import mpdev.aoc2023.day24.Day24_.Companion.overlayGrid
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Nested
@DisplayName("Day 24 Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class TestDay24_ {

    private val filename = "src/test/resources/day24/input.txt"
    private val inputProcessor = InputProcessorDay24()
    private val solution = SolutionProcessorDay24()
    private lateinit var testPuzzle: Day24_

    @BeforeEach
    fun testSetup() {
        testMode = true
        val inputLines = File(filename).readLines()
        testPuzzle = inputProcessor.process(inputLines)
    }

    @Test
    @Order(1)
    fun `Test Get Input`() {
        println(grid.gridToString())
        testPuzzle.blizzardList.forEach { println(it) }
        assertEquals(6, grid.size)
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
        testPuzzle = inputProcessor.process(inputLines)
        println(grid.gridToString())
        println(testPuzzle.blizzardList)
        (0..5).forEach {
            println("$it.")
            testPuzzle.overlay(it)
            println(overlayGrid.gridToString())
        }
    }

    @Test
    @Order(10)
    fun `Test Calculate Part 1`() {
        val expected = "18"
        val result = solution.part1(testPuzzle).first
        println("Start")
        testPuzzle.overlay(0)
        println(overlayGrid.gridToString())
        println("Finish")
        testPuzzle.overlay(18)
        println(overlayGrid.gridToString())
        println("result $result")
        assertEquals(expected, result)
    }

    @Test
    @Order(12)
    fun `Test Calculate Part 2`() {
        val expected = "54"
        val result = solution.part2(testPuzzle).first
        println("result $result")
        assertEquals(expected, result)
    }

}

