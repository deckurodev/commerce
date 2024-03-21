package com.commerce.products.controller

import com.commerce.products.controller.dto.CreateProductRequest
import com.commerce.products.service.ProductService
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
    fun createProduct(@RequestBody createProductRequest: CreateProductRequest)
    {
        productService.createProduct(createProductRequest)
    }
}