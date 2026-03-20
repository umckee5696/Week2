package com.umc.yido

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.yido.databinding.FragmentShopBinding

class ShopFragment : Fragment() {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val TAG = "LIFE_QUIZ"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "ShopFragment : onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "ShopFragment : onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "ShopFragment : onCreateView")
        _binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "ShopFragment : onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ShopFragment : onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ShopFragment : onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ShopFragment : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ShopFragment : onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "ShopFragment : onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ShopFragment : onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "ShopFragment : onDetach")
    }
}
