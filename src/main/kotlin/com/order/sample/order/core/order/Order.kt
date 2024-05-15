package com.order.sample.order.core.order

import java.time.LocalDateTime
import java.util.UUID

data class Order (
    val id: UUID,
    val status: String,
    val clientId: UUID,
    val scheduled: LocalDateTime,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime?,
    val items: List<OrderItem> = emptyList()
)

data class OrderItem (
    val id: UUID,
    val orderId: UUID,
    val status: String,
    val productId: UUID,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime?
)