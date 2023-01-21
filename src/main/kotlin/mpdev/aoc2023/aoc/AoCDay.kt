package mpdev.aoc2023.aoc

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class AoCDay(val day: Int = 0, val part: Int = 0)
