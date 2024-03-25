package com.commerce.products.domain.product

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long? = null,

    var name: String,

    var price: Int
) {
    init {
        if (name.isBlank())
        {
            throw IllegalArgumentException("상품 이름은 필수 입니다.")
        }

        if (price < 0)
        {
            throw IllegalArgumentException("상품 가격은 0원 이상입니다.")
        }
    }

    fun updatePrice(price: Int)
    {
        if (price < 0)
        {
            throw IllegalArgumentException("상품 가격은 0원 이상입니다.")
        }
        this.price = price
    }

    fun updateName(name: String)
    {
        if (name.isBlank())
        {
            throw IllegalArgumentException("상품 이름은 필수 입니다.")
        }
        this.name = name
    }
}