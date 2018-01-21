package com.ivotai.nicknack.general

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.support.v4.graphics.ColorUtils
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.view.Gravity

class RoundCornerButton:AppCompatButton {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    private val unpressed = GradientDrawable()
    private val pressed = GradientDrawable()

    init {
        gravity = Gravity.CENTER
        setTextColor(Color.WHITE)

        val bgColor = (background as? ColorDrawable)?.color ?: Color.RED
        unpressed.setColor(bgColor)
        // 和黑色混合形成暗色
        pressed.setColor(ColorUtils.blendARGB(bgColor, Color.BLACK, 0.2f))

        val bg = StateListDrawable()
        bg.addState(intArrayOf(-android.R.attr.state_pressed), unpressed)
        bg.addState(intArrayOf(android.R.attr.state_pressed), pressed)
        background = bg
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        unpressed.cornerRadius = height * 0.5f
        pressed.cornerRadius = height * 0.5f
    }

}