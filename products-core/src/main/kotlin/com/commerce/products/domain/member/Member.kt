package com.commerce.products.domain.member

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId : Long? = null,

    val name: String,
) {
    init {
        if (name.isBlank())
        {
            throw IllegalArgumentException("member name cannot null")
        }
    }
}