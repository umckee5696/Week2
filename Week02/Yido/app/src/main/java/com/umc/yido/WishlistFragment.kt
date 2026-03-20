package com.umc.yido

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umc.yido.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val TAG = "LIFE_QUIZ"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "WishlistFragment : onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "WishlistFragment : onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "WishlistFragment : onCreateView")
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "WishlistFragment : onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "WishlistFragment : onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "WishlistFragment : onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "WishlistFragment : onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "WishlistFragment : onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "WishlistFragment : onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "WishlistFragment : onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "WishlistFragment : onDetach")
    }
}
