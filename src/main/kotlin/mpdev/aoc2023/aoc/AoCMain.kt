package mpdev.aoc2023.aoc

import mpdev.aoc2023.solutions.AoC2023Inputs
import mpdev.aoc2023.solutions.AoC2023Solutions
import java.util.*

fun main (args: Array<String>) {
    val day = if (args.isEmpty()) Calendar.getInstance().get(Calendar.DAY_OF_MONTH) else args[0].toInt()
    AoC().process(AoC2023Solutions(), AoC2023Inputs(), day)
}

class AoCRunTimeException(override var message: String) : Exception(message)