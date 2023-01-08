package mpdev.aoc2023.common

import mpdev.aoc2023.day24.InputProcessorDay24
import mpdev.aoc2023.day24.SolutionProcessorDay24
import mpdev.aoc2023.daynn.InputProcessorDayNN
import mpdev.aoc2023.daynn.SolutionProcessorDayNN


class DaySpecific {
    companion object {
        fun getProcessor(part: Int, day: Int): PuzzleProcessor<*> {
            return when (day) {

                1 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                2 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                3 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                4 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                5 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                6 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                7 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                8 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                9 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                10 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                11 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                12 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                13 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                14 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                15 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                16 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                17 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                18 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                19 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                20 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                21 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                22 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                23 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())
                24 -> PuzzleProcessor(part, day, InputProcessorDay24(), SolutionProcessorDay24())
                25 -> PuzzleProcessor(part, day, InputProcessorDayNN(), SolutionProcessorDayNN())

                else ->
                    throw ProgramArgException("could not determine puzzle processor class for day $day - ${Constants.USAGE}")
            }
        }
    }
}