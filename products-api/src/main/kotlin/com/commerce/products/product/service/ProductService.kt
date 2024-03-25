package com.commerce.products.product.service

import com.commerce.products.product.controller.dto.CreateProductRequest
import com.commerce.products.product.controller.dto.UpdateProductRequest
import com.commerce.products.domain.product.Product
import com.commerce.products.domain.product.ProductRepository
import com.commerce.products.domain.product.event.ProductCreatedEvent
import com.commerce.products.util.findByIdOrThrow
import lombok.RequiredArgsConstructor
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@RequiredArgsConstructor
@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun createProduct(createProductRequest: CreateProductRequest)
    {
        val product = productRepository.save(
            Product(
                name = createProductRequest.name,
                price = createProductRequest.price
            )
        )

        applicationEventPublisher.publishEvent(ProductCreatedEvent(product.productId!!, product.price));
    }

    fun updateProduct(productId: Long, updateProductRequest: UpdateProductRequest)
    {
        val product = productRepository.findByIdOrThrow(productId)
        product.updatePrice(updateProductRequest.price)
        product.updateName(updateProductRequest.name)

        productRepository.save(product)
    }
}