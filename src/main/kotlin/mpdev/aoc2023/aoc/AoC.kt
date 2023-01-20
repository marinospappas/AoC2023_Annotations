package mpdev.aoc2023.aoc

class AoC {
    fun process(aocSolver: Any, aocInput: Any, day: Int) {
        processDaySolution(aocSolver, processDayInput(aocInput, day), day)
    }

    private fun processDayInput(aocInput: Any, day: Int): Any {
        verifyIsAoCInput(aocInput)
        val clazz: Class<*> = aocInput.javaClass
        val inputData = listOf<String>()
        for (method in clazz.declaredMethods) {
            if (method.isAnnotationPresent(AoCDay::class.java)
                && method.getAnnotation(AoCDay::class.java).day == day
            ) {
                return method.invoke(aocInput, inputData)
            }
        }
        throw AoCRunTimeException("Could not find input method for day $day in class ${clazz.simpleName}")
    }

    private fun processDaySolution(aoCSolution: Any, dayObject: Any, day: Int) {
        verifyIsAoCSolution(aoCSolution)
        val clazz: Class<*> = aoCSolution.javaClass
        for (method in clazz.declaredMethods) {
            if (method.isAnnotationPresent(AoCDay::class.java) && method.getAnnotation(AoCDay::class.java).day == day) {
                method.invoke(aoCSolution, dayObject)
                return
            }
        }
        throw AoCRunTimeException("Could not find solution method for day $day in class ${clazz.simpleName}")
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
