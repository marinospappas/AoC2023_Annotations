package mpdev.aoc2023.utils.annimation

import java.awt.Color
import java.awt.Point

class AnimationObject {
    var startPoint: Point = Point(80,80)
    var rows: Int = 40
    var columns: Int = 40
    var title1: String = "Animation"
    var title2: String = "Demo"
    var tileSize: Int = 8
    var timerInterval = 1000
    var bgndColour = Color(51, 51, 51)
    var gridOn: Boolean = false
    var gridColour: Color = Color.GRAY
    var items: MutableList<AnimationItem> = mutableListOf()
    var waitForEnter: Boolean = false
    var debug: Boolean = false

    init {
        addItem()
    }

    fun addItem() {
        if (debug) println("adding empty item to AnimationItems")
        items.add(AnimationItem(mutableListOf()))
    }

    fun copyLastItem(): Int {
        val lastItem = items.last()
        items.add(AnimationItem(mutableListOf(), lastItem.shape, lastItem.colour, -1))
        lastItem.data.forEach {  items.last().data.add(AnimationPixel(Point(it.p.x,it.p.y), it.shape, it.colour)) }
        if (debug) println("adding last item once more to AnimationItems: $lastItem")
        return items.lastIndex
    }

    fun addPixel(p: Point, shape: Int = SHAPE_DEFAULT, colour: Color = COLOUR_DEFAULT) {
        items.last().data.add(AnimationPixel(p, shape, colour))
    }

    fun removeLastPixel() {
        items.last().data.removeLast()
    }

    fun repeatFromItem(itemIndex: Int) {
        items.last().repeatFromItem = itemIndex
    }

    fun start() = AnimationFrame(this)
}

const val SHAPE_CIRCLE = 0
const val SHAPE_SQUARE = 1
const val SHAPE_DEFAULT = -1
val COLOUR_DEFAULT: Color = Color.BLACK

data class AnimationItem(val data: MutableList<AnimationPixel>, val shape: Int = SHAPE_SQUARE,
                    val colour: Color = Color(30, 30,30), var repeatFromItem: Int = -1)

data class AnimationPixel(val p: Point, val shape: Int = SHAPE_DEFAULT, val colour: Color = COLOUR_DEFAULT)