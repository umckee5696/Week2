package com.umc.yido

data class ProductData(
    val imageResId: Int,         // 신발 이미지 리소스 ID (예: R.drawable.img_shoe_1)
    val isBestSeller: Boolean,   // 주황색 BestSeller 태그 표시 여부
    var isWishlisted: Boolean,   // 하트 아이콘 빨간색 칠하기 여부
    val title: String,           // 제품명
    val subtitle: String,        // 제품 설명 (카테고리)
    val colorsText: String,      // 색상 개수
    val price: String,           // 가격
    var isInCart: Boolean = false// 장바구니 추가 여부
)
