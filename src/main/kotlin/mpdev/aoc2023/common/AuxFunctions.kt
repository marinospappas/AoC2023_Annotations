package mpdev.aoc2023.common

import mpdev.aoc2023.utils.annimation.AnimationObject
import java.util.Calendar

object Constants {
    const val AOC = "AoC 2023"
    const val AUTHOR = "Marinos Pappas"
    const val USAGE = "usage: Main -part1|-part2 -dayN -a"
}

var testMode = false
var doAnimation = false
val animationObject = AnimationObject()

/** get prt 1 or 2 from args */
fun getPart1or2(args: Array<String>): Int {
    for (i in args.indices)
        if (args[i].startsWith("-part"))
            return when (args[i]) {
                "-part1" -> 1
                "-part2" -> 2
                else -> throw ProgramArgException("invalid argument -part1/2 ${Constants.USAGE}")
            }
    return 0
}

/** get day from args */
fun getDay(args: Array<String>): Int {
    for (i in args.indices)
        if (args[i].startsWith("-day")) {
            val day = args[i].substring(4).toInt()
            if (day !in 1..25)
                throw ProgramArgException("invalid -day$day ${Constants.USAGE}")
            return day
        }
    return Calendar.getInstance().get(Calendar.DAY_OF_MONTH)    // return today's date by default
}

/** get day from args */
fun getAnimation(args: Array<String>): Boolean {
    for (i in args.indices)
        if (args[i] == "-a")
            return true
    return false
}
