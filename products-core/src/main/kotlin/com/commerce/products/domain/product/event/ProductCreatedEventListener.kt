package com.commerce.products.domain.product.event

import com.commerce.products.logger
import lombok.extern.slf4j.Slf4j
import org.hibernate.internal.CoreLogging.logger
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionalEventListener
@Component
class ProductCreatedEventListener(
) {
    val log = logger()

    @TransactionalEventListener
    fun handle(productCreatedEvent: ProductCreatedEvent) {
        log.info("productCreatedEvent")
    }
}