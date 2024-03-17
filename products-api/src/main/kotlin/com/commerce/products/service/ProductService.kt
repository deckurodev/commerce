package com.commerce.products.service

import com.commerce.products.domain.Product
import com.commerce.products.domain.ProductRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@RequiredArgsConstructor
@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    @Transactional
    fun save() {
        productRepository.save(Product(name = "D"))
    }
}