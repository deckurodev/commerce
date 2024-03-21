package com.commerce.products.domain

import org.assertj.core.api.Assertions
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