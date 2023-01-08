package mpdev.aoc2023.common

abstract class InputProcessor<P> {
    /** process input into Puzzle Class */
    abstract fun process(input: List<String>): P
}
