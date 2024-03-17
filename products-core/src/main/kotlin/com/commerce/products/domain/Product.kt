package com.commerce.products.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import javax.annotation.processing.Generated

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long? = null,

    val name: String,
) {
    init {
        if (name.isBlank())
        {
            throw IllegalArgumentException("상품 이름은 필수 입니다.")
        }
    }
}