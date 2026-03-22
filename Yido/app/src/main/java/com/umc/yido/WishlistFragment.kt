package com.umc.yido

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
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

        // onViewCreated에서는 레이아웃 설정만 (데이터 갱신은 onResume에서 진행)
        binding.rvWishlistList.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "WishlistFragment : onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "WishlistFragment : onResume")
        
        // Wishlist 탭 진입 시마다 찜된 상품 목록만 필터링하여 최신화
        val wishlistedProducts = GlobalData.shopProducts.filter { it.isWishlisted }
        binding.rvWishlistList.adapter = ProductAdapter(wishlistedProducts) { globalIndex ->
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )
                .replace(R.id.main_fragment_container, ProductDetailFragment.newInstance(globalIndex))
                .addToBackStack(null)
                .commit()
        }
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
