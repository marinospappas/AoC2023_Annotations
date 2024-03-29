package mpdev.aoc2023.solutions

import kotlin.system.measureTimeMillis

class Day01 {
    val msg = "AoC 2023 Day 1"
    var elapsed1 = 0L
    var elapsed2 = 0L
    var dataList: MutableList<Elf> = mutableListOf()
    data class Elf(var id: Int, var calories: Int = 0)

    private fun getCaloriesList() = dataList.groupingBy { it.id }.aggregate { _, accumulator: Int?, element, first ->
        if (first) element.calories else accumulator?.plus(element.calories)
    }.values.toMutableList().sortedBy { it }

    /** part 1 calculation */
    fun part1(): String {
        val result: String
        elapsed1 = measureTimeMillis { result = getCaloriesList().last()!!.toString() }
        return result
    }

    /** part 2 calculation */
    fun part2(): String {
        val result: String
        elapsed2 = measureTimeMillis {
            val caloriesList = getCaloriesList()
            val lastIndex = caloriesList.lastIndex
            result = (caloriesList[lastIndex]?.plus(caloriesList[lastIndex - 1]!!)?.plus(caloriesList[lastIndex - 2]!!) ?: 0)
                .toString()
        }
        return result
    }
}