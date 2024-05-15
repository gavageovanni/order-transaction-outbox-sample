package com.order.sample.order.infrastructure.db

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "order_item")
data class OrderItemModel(
        @Id
        @Column(name = "id")
        private val id: UUID,
        @Column(name = "order_id")
        private val orderId: UUID,
        @Column(name = "status")
        private val status: String,
        @Column(name = "product_id")
        private val productId: UUID,
        @Column(name = "created_at")
        private val createdAt: LocalDateTime = LocalDateTime.now(),
        @Column(name = "updated_at")
        private val updatedAt: LocalDateTime?
)