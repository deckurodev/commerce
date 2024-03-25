package com.commerce.products.domain.product.event

data class ProductCreatedEvent(
    val productId: Long,
    val price: Int,
)