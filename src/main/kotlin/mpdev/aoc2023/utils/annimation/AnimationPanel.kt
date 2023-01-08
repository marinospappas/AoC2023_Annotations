package mpdev.aoc2023.utils.annimation

import java.awt.Graphics
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.time.LocalTime
import javax.swing.JPanel
import javax.swing.Timer
import kotlin.system.exitProcess

class AnimationPanel(val animationObject: AnimationObject) : JPanel(), KeyListener , ActionListener {
    var animationManager: AnimationManager
    private val timer: Timer
    private val timerInterval = animationObject.timerInterval

    init {
        if (animationObject.debug) println ("${LocalTime.now()} animation Panel created")
        this.isOpaque = true
        background = animationObject.bgndColour
        addKeyListener(this)
        this.isFocusable = true
        this.requestFocus()
        animationManager = AnimationManager(this, animationObject)
        timer = Timer(timerInterval, this)
        timer.start()
    }

    override fun paintComponent(g: Graphics) {
        if (animationObject.debug) println("${LocalTime.now()} paintComponent: calling animationManager.renderObject")
        super.paintComponent(g)
        animationManager.renderObject(g)
    }

    override fun actionPerformed(e: ActionEvent) {
        if (animationObject.debug) println("${LocalTime.now()} actionPerformed: calling animationManager.draw")
        animationManager.draw()
    }

    override fun keyPressed(e: KeyEvent) {
        when (e.keyCode) {
            KeyEvent.VK_ESCAPE -> exitProcess(0)
            KeyEvent.VK_ENTER -> animationObject.waitForEnter = false
        }
    }

    override fun keyTyped(e: KeyEvent) {}
    override fun keyReleased(e: KeyEvent) {}

}

