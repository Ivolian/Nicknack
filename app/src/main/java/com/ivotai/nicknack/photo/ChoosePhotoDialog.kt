package com.ivotai.nicknack.photo

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.ConvertUtils
import com.ivotai.nicknack.R

class ChoosePhotoDialog : Dialog {

    constructor(context: Context?) : super(context, R.style.Dialog)
    constructor(context: Context?, themeResId: Int) : super(context, themeResId)
    constructor(context: Context?, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?) : super(context, cancelable, cancelListener)

    var rootView: View  = View.inflate(context, R.layout.dialog_choose_photo, null)


    init {
        val g = GradientDrawable()
        g.setColor(Color.WHITE)
        g.cornerRadius = 40f
        rootView.background = g
        setContentView(rootView)
    }

    fun addOnClickListeners(l1: View.OnClickListener, l2:View.OnClickListener): ChoosePhotoDialog {
        rootView.findViewById<TextView>(R.id.tvTakePhoto).setOnClickListener(l1)
        rootView.findViewById<TextView>(R.id.tvOpenAlbum).setOnClickListener(l2)
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.attributes.width = ConvertUtils.dp2px(300f);
    }
}