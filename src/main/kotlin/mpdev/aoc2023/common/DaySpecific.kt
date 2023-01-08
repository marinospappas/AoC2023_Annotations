package mpdev.aoc2023.common

import mpdev.aoc2023.day24.InputProcessorDay24
import mpdev.aoc2023.day24.SolutionProcessorDay24


class DaySpecific {
    companion object {
        fun getProcessor(part1Or2: Int, day: Int): PuzzleProcessor<*> {
            return when (day) {

                24 -> PuzzleProcessor(
                    part1Or2,
                    day,
                    InputProcessorDay24(),
                    SolutionProcessorDay24()
                )

                else ->
                    throw ProgramArgException("could not determine puzzle processor class for day $day - ${Constants.USAGE}")
            }
        }
    }
}