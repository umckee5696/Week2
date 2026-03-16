package com.example.umc_week01

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_week01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 행복
        binding.ivHappy.setOnClickListener {
            binding.tvHappy.setTextColor(Color.parseColor("#FFD54F"))
        }

        // 흥분
        binding.ivExcited.setOnClickListener {
            binding.tvExcited.setTextColor(Color.parseColor("#64B5F6"))
        }

        // 평범
        binding.ivNormal.setOnClickListener {
            binding.tvNormal.setTextColor(Color.parseColor("#9575CD"))
        }

        // 불안
        binding.ivAnxious.setOnClickListener {
            binding.tvAnxious.setTextColor(Color.parseColor("#81C784"))
        }

        // 화남
        binding.ivAngry.setOnClickListener {
            binding.tvAngry.setTextColor(Color.parseColor("#E57373"))
        }
    }
}