package com.commerce.products.service

import com.commerce.products.controller.dto.CreateProductRequest
import com.commerce.products.controller.dto.UpdateProductRequest
import com.commerce.products.domain.Product
import com.commerce.products.domain.ProductRepository
import com.commerce.products.util.findByIdOrThrow
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    @Transactional
    fun createProduct(createProductRequest: CreateProductRequest)
    {
        productRepository.save(
            Product(
                name = createProductRequest.name,
                price = createProductRequest.price
            )
        )
    }

    @Transactional
    fun updateProduct(productId: Long, updateProductRequest: UpdateProductRequest)
    {
        val product = productRepository.findByIdOrThrow(productId)
        product.updatePrice(updateProductRequest.price)
        product.updateName(updateProductRequest.name)

        productRepository.save(product)
    }
}