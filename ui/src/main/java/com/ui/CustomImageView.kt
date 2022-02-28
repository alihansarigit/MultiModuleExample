package com.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

class CustomImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    onClick: OnClickListener? = null) : AppCompatImageView(context, attrs) {

    var onClick: OnClickListener? = null
    set(value) {
        this.setOnClickListener(value)
    }

    init {
        this.onClick = onClick
    }


}