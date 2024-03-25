package com.commerce.products.product.controller

import com.commerce.products.product.controller.dto.CreateProductRequest
import com.commerce.products.product.service.ProductService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")
class ProductController(
    private val productService: ProductService,
) {
    @PostMapping
    fun createProduct(@Valid @RequestBody createProductRequest: CreateProductRequest)
    {
        productService.createProduct(createProductRequest)
    }
}