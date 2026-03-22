package com.umc.yido

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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
        refreshCartList()
    }

    private fun refreshCartList() {
        val cartItems = GlobalData.shopProducts.filter { it.isInCart }.toMutableList()

        if (cartItems.isEmpty()) {
            binding.rvCartList.visibility = View.GONE
            binding.cartIvEmptyIcon.visibility = View.VISIBLE
            binding.cartTvEmptyMessage.visibility = View.VISIBLE
        } else {
            binding.rvCartList.visibility = View.VISIBLE
            binding.cartIvEmptyIcon.visibility = View.GONE
            binding.cartTvEmptyMessage.visibility = View.GONE

            val adapter = CartAdapter(
                cartItems, 
                onItemClicked = { product ->
                    val globalIndex = GlobalData.shopProducts.indexOf(product)
                    if (globalIndex != -1) {
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
                },
                onDeleteClicked = { product ->
                    // X 버튼 클릭 → 장바구니에서 삭제
                    val globalIndex = GlobalData.shopProducts.indexOf(product)
                    if (globalIndex != -1) {
                        GlobalData.shopProducts[globalIndex].isInCart = false
                    }
                    refreshCartList() // 리스트 갱신
                }
            )
            binding.rvCartList.layoutManager = LinearLayoutManager(requireContext())
            binding.rvCartList.adapter = adapter
        }
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
