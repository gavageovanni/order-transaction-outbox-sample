package com.order.sample.order.core.order

import org.springframework.stereotype.Component

@Component
class OrderModule(private val orderRepository: OrderRepository) {
    fun processOrders() {
        orderRepository.findOrders().forEach {
            println("Processing order: ${it.id}")
        }
    }
}