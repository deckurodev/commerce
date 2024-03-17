package com.commerce.products.controller

import com.commerce.products.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    val productService: ProductService
) {
    @GetMapping("/api")
    fun save() {
        productService.save()
    }
}