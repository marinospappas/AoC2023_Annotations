package mpdev.aoc2023.daynn

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.io.File

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Nested
@DisplayName("Day 24 Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class TestDayNN {

    private val filename = "src/test/resources/daynn/input.txt"
    private val inputProcessor = InputProcessorDayNN()
    private val solution = SolutionProcessorDayNN()
    private lateinit var testPuzzle: DayNN

    @BeforeEach
    fun testSetup() {
        val inputLines = File(filename).readLines()
        testPuzzle = inputProcessor.process(inputLines)
    }

    @Test
    @Order(1)
    fun `Test Get Input`() {
        testPuzzle.dataList.forEach { println(it) }
        assertEquals(0, testPuzzle.dataList.size)
    }

    @Test
    @Order(10)
    fun `Test Calculate Part 1`() {
        val expected = "0"
        val result = solution.part1(testPuzzle).first
        println("result $result")
        assertEquals(expected, result)
    }

    @Test
    @Order(12)
    fun `Test Calculate Part 2`() {
        val expected = "0"
        val result = solution.part2(testPuzzle).first
        println("result $result")
        assertEquals(expected, result)
    }

}

