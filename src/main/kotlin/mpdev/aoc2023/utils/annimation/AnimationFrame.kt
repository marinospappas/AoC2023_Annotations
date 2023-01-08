package mpdev.aoc2023.utils.annimation

import java.awt.Color
import java.awt.Font
import javax.swing.JFrame
import javax.swing.JLabel


class AnimationFrame(animationObject: AnimationObject) : JFrame() {
    private val animationPanel: AnimationPanel
    private val subTitle: JLabel

    init {
        title = animationObject.title1
        val width = animationObject.columns * animationObject.tileSize
        val height = animationObject.rows * animationObject.tileSize
        this.setBounds(animationObject.startPoint.x, animationObject.startPoint.y,
            width+40+1, height+40+20+animationObject.tileSize/2)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        this.isResizable = false
        contentPane.layout = null
        contentPane.background = Color.BLACK
        subTitle = JLabel(animationObject.title2)
        subTitle.setBounds(0, 0, width/2, animationObject.tileSize/2+4)
        subTitle.font = Font(subTitle.font.name, Font.PLAIN, animationObject.tileSize/2)
        subTitle.foreground = Color.WHITE
        contentPane.add(subTitle)
        animationPanel = AnimationPanel(animationObject)
        animationPanel.setBounds(20, animationObject.tileSize/2+4, width+1, height+1)
        this.add(animationPanel)
        this.isVisible = true
        // loop until exit key is pressed
        while (animationPanel.animationManager.isRunning) Thread.sleep(100)
    }

}

