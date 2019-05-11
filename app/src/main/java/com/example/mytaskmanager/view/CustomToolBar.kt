package com.example.mytaskmanager.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.example.mytaskmanager.R
import kotlinx.android.synthetic.main.custom_toolbar.view.*

class CustomToolBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater
            .from(context)
            .inflate(R.layout.custom_toolbar, this, true)
    }

    val title = midTitle
    val leftButton = leftBtn
    val rightButton = rightBtn

    fun setLeftButton(src: Int?,show: Boolean) {
        if (show) {
            leftButton.visibility = View.VISIBLE
        }else{
            leftButton.visibility = View.GONE
        }
        src?.let { leftButton.setImageResource(it) }

    }

    fun setRightButton(src: Int?,show: Boolean) {
        if (show) {
            rightButton.visibility = View.VISIBLE
        }else{
            rightButton.visibility = View.GONE
        }
        src?.let { rightButton.setImageResource(it) }
    }

    fun setTitle(string: String) {
        title.text = string
    }

    fun setLeftClickListener(listener: OnClickListener) {
        leftButton.setOnClickListener(listener)
    }

    fun setRightClickListener(listener: OnClickListener) {
        rightButton.setOnClickListener(listener)
    }
}