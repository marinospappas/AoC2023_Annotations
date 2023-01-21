package mpdev.aoc2023.aoc

import java.io.File

class AoC {
    fun process(aocSolver: Any, aocInput: Any, day: Int, part: Int) {
        processDaySolution(aocSolver, processDayInput(aocInput, day), day, part)
    }

    fun processDayInput(aocInput: Any, day: Int, inputLines: List<String> =
        File("src/main/resources/input${String.format("%02d", day)}.txt").readLines()): Any {
        verifyIsAoCInput(aocInput)
        val clazz: Class<*> = aocInput.javaClass
        for (method in clazz.declaredMethods) {
            if (method.isAnnotationPresent(AoCDay::class.java) &&
                method.getAnnotation(AoCDay::class.java).day == day)
                return method.invoke(aocInput, inputLines)
        }
        throw AoCRunTimeException("Could not find input method for day $day in class ${clazz.simpleName}")
    }

    private fun processDaySolution(aoCSolution: Any, dayObject: Any, day: Int, part: Int = 0) {
        verifyIsAoCSolution(aoCSolution)
        val clazz: Class<*> = aoCSolution.javaClass
        for (method in clazz.declaredMethods) {
            if (method.isAnnotationPresent(AoCDay::class.java) &&
                method.getAnnotation(AoCDay::class.java).day == day &&
                method.getAnnotation(AoCDay::class.java).part == part) {
                method.invoke(aoCSolution, dayObject)
                return
            }
        }
        throw AoCRunTimeException(
            "Could not find solution method for day $day ${if(part==0) "" else "part $part"} in class ${clazz.simpleName}"
        )
    }

    private fun verifyIsAoCInput(obj: Any) {
        val clazz: Class<*> = obj.javaClass
        if (!clazz.isAnnotationPresent(AoCInput::class.java))
            throw AoCRunTimeException("Class ${clazz.simpleName} is not @AoCInput")

    }

    private fun verifyIsAoCSolution(obj: Any) {
        val clazz: Class<*> = obj.javaClass
        if (!clazz.isAnnotationPresent(AoCSolution::class.java))
            throw AoCRunTimeException("Class ${clazz.simpleName} is not @AoCSolution")
    }
}
