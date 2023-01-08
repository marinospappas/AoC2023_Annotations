package mpdev.aoc2023.daynn

import mpdev.aoc2023.common.InputProcessor
import mpdev.aoc2023.utils.matchRegExp
import mpdev.aoc2023.utils.regexMatch

class InputProcessorDayNN: InputProcessor<DayNN>() {
    override fun process(input: List<String>): DayNN {
        val datalist = mutableListOf<DayNN.PuzzleClass>()
        input.forEach { line ->
            if (line.matchRegExp(Regex("""^(\d+)$"""))) {
                val (n) = regexMatch!!.destructured
                datalist.add(DayNN.PuzzleClass(n.toInt()))
            }
        }
        return DayNN(datalist)
    }
}
