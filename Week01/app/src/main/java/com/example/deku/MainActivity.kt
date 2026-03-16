package com.example.deku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.deku.data.EmotionItem
import com.example.deku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnEmotionClickListener()
    }

    /**
     * 감정우표 클릭 이벤트 함수
     */
    private fun setOnEmotionClickListener() {
        // EmotionItem(아이콘, 텍스트, 색상)을 리스트로 묶어서 관리
        val emotionItems = listOf(
            EmotionItem(binding.ivHappy, binding.tvHappy, getColor(R.color.emotion_happy)),
            EmotionItem(binding.ivExcited, binding.tvExcited, getColor(R.color.emotion_excited)),
            EmotionItem(binding.ivNormal, binding.tvNormal, getColor(R.color.emotion_normal)),
            EmotionItem(binding.ivAngry, binding.tvAngry, getColor(R.color.emotion_angry)),
            EmotionItem(binding.ivAnxious, binding.tvAnxious, getColor(R.color.emotion_anxious))
        )

        emotionItems.forEach { item ->
            item.emotion.setOnClickListener {
                if (!item.isClicked) {
                    item.emotionText.setTextColor(item.emotionColor)
                } else {
                    item.emotionText.setTextColor(getColor(R.color.black))
                }
                item.isClicked = !item.isClicked
            }
        }
    }
}
