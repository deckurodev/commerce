package com.commerce.products.product.controller.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull

data class CreateProductRequest(

    @NotBlank(message = "Name must not be blank")
    val name : String,

    @Min(value = 0, message = "가격은 0보다 커야합니다.")
    val price : Int,
)