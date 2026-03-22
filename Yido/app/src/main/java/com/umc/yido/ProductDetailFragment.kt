package com.umc.yido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.umc.yido.databinding.FragmentProductDetailBinding

class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    
    private var globalDataIndex: Int = -1

    companion object {
        private const val ARG_INDEX = "arg_index"

        fun newInstance(index: Int): ProductDetailFragment {
            val fragment = ProductDetailFragment()
            val args = Bundle()
            args.putInt(ARG_INDEX, index)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        globalDataIndex = arguments?.getInt(ARG_INDEX, -1) ?: -1
        
        if (globalDataIndex == -1 || globalDataIndex >= GlobalData.shopProducts.size) { // Invalid index fallback
            parentFragmentManager.popBackStack()
            return
        }
        
        val product = GlobalData.shopProducts[globalDataIndex]
        
        // Update views
        binding.ivDetailMainImg.setImageResource(product.imageResId)
        binding.ivDetailSub1.setImageResource(product.imageResId)
        binding.ivDetailSub2.setImageResource(product.imageResId)
        binding.ivDetailSub3.setImageResource(product.imageResId)
        binding.ivDetailSub4.setImageResource(product.imageResId)
        
        binding.tvDetailTopTitle.text = product.title
        binding.tvDetailTitle.text = product.title
        binding.tvDetailSubtitle.text = product.subtitle
        binding.tvDetailPrice.text = product.price
        
        binding.btnDetailWishlist.text = if (product.isWishlisted) "위시리스트 ♥" else "위시리스트 ♡"

        // Click listeners
        binding.ivDetailBack.setOnClickListener { view ->
            view.postDelayed({
                parentFragmentManager.popBackStack()
            }, 150)
        }
        
        binding.btnDetailCart.setOnClickListener {
            GlobalData.shopProducts[globalDataIndex].isInCart = true
            Toast.makeText(requireContext(), "장바구니에 담겼습니다.", Toast.LENGTH_SHORT).show()
        }
        
        binding.btnDetailWishlist.setOnClickListener {
            val isNowWishlisted = !product.isWishlisted
            GlobalData.shopProducts[globalDataIndex].isWishlisted = isNowWishlisted
            binding.btnDetailWishlist.text = if (isNowWishlisted) "위시리스트 ♥" else "위시리스트 ♡"
            val msg = if (isNowWishlisted) "위시리스트에 담겼습니다." else "위시리스트에서 제외되었습니다."
            Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
