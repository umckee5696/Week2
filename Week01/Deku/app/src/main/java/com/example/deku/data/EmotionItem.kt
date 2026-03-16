package com.example.deku.data

import android.widget.ImageView
import android.widget.TextView

data class EmotionItem(
    val emotion: ImageView,
    val emotionText: TextView,
    val emotionColor: Int,
    var isClicked: Boolean = false
)
