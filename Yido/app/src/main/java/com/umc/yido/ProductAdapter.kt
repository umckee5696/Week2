package com.umc.yido

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc.yido.databinding.ItemProductBinding

class ProductAdapter(
    private val productList: List<ProductData>,
    private val isHomeMode: Boolean = false,
    private val onItemClicked: ((Int) -> Unit)? = null
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductData) {
            // 아이템 클릭 시 상세 페이지 이동
            binding.root.setOnClickListener { view ->
                view.postDelayed({
                    val globalIndex = GlobalData.shopProducts.indexOf(product)
                    if (globalIndex != -1) {
                        onItemClicked?.invoke(globalIndex)
                    }
                }, 150)
            }

            binding.ivProduct.setImageResource(product.imageResId)
            binding.tvTitle.text = product.title
            binding.tvSubtitle.text = product.subtitle
            binding.tvColors.text = product.colorsText
            binding.tvPrice.text = product.price

            // 홈 화면용 심플 모드
            if (isHomeMode) {
                binding.tvSubtitle.visibility = View.GONE
                binding.tvColors.visibility = View.GONE
                binding.flHeartContainer.visibility = View.GONE
                binding.tvBestseller.visibility = View.GONE
                binding.tvPrice.visibility = View.GONE
                
                // 가로 스크롤을 위해 width를 160dp 고정값으로 설정
                val params = binding.root.layoutParams
                params.width = (binding.root.context.resources.displayMetrics.density * 240).toInt()
                binding.root.layoutParams = params
            } else {
                binding.tvSubtitle.visibility = View.VISIBLE
                binding.tvColors.visibility = View.VISIBLE
                binding.flHeartContainer.visibility = View.VISIBLE
                binding.tvPrice.visibility = View.VISIBLE

                if (product.isBestSeller) {
                    binding.tvBestseller.visibility = View.VISIBLE
                } else {
                    binding.tvBestseller.visibility = View.GONE
                }

                if (product.isWishlisted) {
                    binding.ivHeart.setImageResource(R.drawable.ic_heart_filled_red)
                } else {
                    binding.ivHeart.setImageResource(R.drawable.ic_nav_wishlist) // 빈 하트
                }
            }

            // 하트 클릭 처리 (구매 탭 전용)
            binding.flHeartContainer.setOnClickListener { view ->
                view.postDelayed({
                    if (!isHomeMode) {
                        product.isWishlisted = !product.isWishlisted
                        notifyItemChanged(bindingAdapterPosition)
                    }
                }, 150)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
