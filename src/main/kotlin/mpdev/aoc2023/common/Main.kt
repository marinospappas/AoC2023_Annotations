package mpdev.aoc2023.common

fun main(args: Array<String>) {

    val part = getPart1or2(args)
    val day = getDay(args)
    doAnimation = getAnimation(args)

    val puzzleProcessor = DaySpecific.getProcessor(part, day)

    puzzleProcessor.process()

    if (doAnimation)
        animationObject.start()
}