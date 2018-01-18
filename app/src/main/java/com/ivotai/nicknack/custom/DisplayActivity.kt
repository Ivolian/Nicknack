package com.ivotai.nicknack.custom

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.ivotai.nicknack.R

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val f = findViewById<ViewGroup>(R.id.f)
        val btn = RoundCornerButton(this)
        val params = ViewGroup.LayoutParams(300,60)
        f.addView(btn,params)
    }
}
