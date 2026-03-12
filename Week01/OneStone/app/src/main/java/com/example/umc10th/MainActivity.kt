package com.example.umc10th

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.umc10th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 아이템 클릭 시 색상 반영 바인딩 함수
        setupFaceClickListeners()
    }

    private fun setupFaceClickListeners() {
        // (아이콘, 텍스트, 컬러)를 묶어서 리스트로 관리
        val faceItems = listOf(
            Triple(binding.icFace1, binding.textFace1, R.color.face1),
            Triple(binding.icFace2, binding.textFace2, R.color.face2),
            Triple(binding.icFace3, binding.textFace3, R.color.face3),
            Triple(binding.icFace4, binding.textFace4, R.color.face4),
            Triple(binding.icFace5, binding.textFace5, R.color.face5)
        )

        // 반복문을 통해 클릭 리스너 일괄 등록
        faceItems.forEach { (icon, text, colorRes) ->
            icon.setOnClickListener {
                text.setTextColor(ContextCompat.getColor(this, colorRes))
            }
        }
    }
}