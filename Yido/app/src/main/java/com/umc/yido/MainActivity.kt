package com.umc.yido

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.umc.yido.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG = "LIFE_QUIZ"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity : onCreate")
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, HomeFragment())
                .commit()
        }

    
        binding.mainBottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, HomeFragment())
                        .commit()
                    true
                }
                R.id.nav_shop -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, ShopFragment())
                        .commit()
                    true
                }
                R.id.nav_wishlist -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, WishlistFragment())
                        .commit()
                    true
                }
                R.id.nav_cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, CartFragment())
                        .commit()
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_fragment_container, ProfileFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }

    /** CartFragment에서 호출: 구매하기(Shop) 탭으로 전환 */
    fun changeToShopTab() {
        binding.mainBottomNav.selectedItemId = R.id.nav_shop
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity : onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity : onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity : onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity : onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity : onRestart")
    }
}