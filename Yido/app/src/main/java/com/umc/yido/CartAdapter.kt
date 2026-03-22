package com.umc.yido

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.yido.databinding.ItemCartBinding

class CartAdapter(
    private val cartItems: MutableList<ProductData>,
    private val onItemClicked: (ProductData) -> Unit,
    private val onDeleteClicked: (ProductData) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductData) {
            // 상품 전체 영역 클릭 시 상세페이지로 이동
            binding.root.setOnClickListener { view ->
                view.postDelayed({
                    onItemClicked(product)
                }, 150)
            }

            binding.ivCartItemImg.setImageResource(product.imageResId)
            binding.tvCartItemTitle.text = product.title
            binding.tvCartItemSubtitle.text = product.subtitle
            binding.tvCartItemPrice.text = product.price

            // X 버튼 클릭 → 장바구니에서 삭제
            binding.ivCartItemDelete.setOnClickListener { view ->
                view.postDelayed({
                    onDeleteClicked(product)
                }, 150)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItems[position])
    }

    override fun getItemCount(): Int = cartItems.size
}
