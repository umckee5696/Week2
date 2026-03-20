package com.umc.yido

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.yido.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val TAG = "LIFE_QUIZ"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "CartFragment : onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "CartFragment : onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "CartFragment : onCreateView")
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "CartFragment : onViewCreated")

    
        binding.cartBtnOrder.setOnClickListener {
            (activity as? MainActivity)?.changeToShopTab()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "CartFragment : onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "CartFragment : onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "CartFragment : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "CartFragment : onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "CartFragment : onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "CartFragment : onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "CartFragment : onDetach")
    }
}
