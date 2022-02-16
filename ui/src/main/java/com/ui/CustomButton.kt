package com.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    onClick: OnClickListener? = null) : AppCompatButton(context, attrs) {

    var onClick: OnClickListener? = null
    set(value) {
        this.setOnClickListener(value)
    }

    init {
        this.onClick = onClick
    }


}