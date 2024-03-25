package com.commerce.products.domain

import com.commerce.products.domain.product.Product
import com.commerce.products.domain.product.ProductRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class ProductRepositoryTest(
) {
    @Autowired
    lateinit var productRepository: ProductRepository

    @Test
    fun save() {
        val save = productRepository.save(Product(name = "삼다수", price = 10000))
        assertThat(save.price).isEqualTo(10000)
        assertThat(save.name).isEqualTo("삼다수")
        assertThat(save.productId).isNotNull()
    }
}