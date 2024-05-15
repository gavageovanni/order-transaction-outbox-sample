package com.order.sample.order.infrastructure.db

import com.order.sample.order.core.order.Order
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "order")
data class OrderModel(
        @Id
        @Column(name = "id")
        val id: UUID,
        @Column(name = "status")
        val status: String,
        @Column(name = "client_id")
        val clientId: UUID,
        @Column(name = "scheduled")
        val scheduled: LocalDateTime,
        @Column(name = "created_at")
        val createdAt: LocalDateTime = LocalDateTime.now(),
        @Column(name = "updated_at")
        val updatedAt: LocalDateTime?,
)

fun OrderModel.toOrder() = Order(
        id = id,
        status = status,
        clientId = clientId,
        scheduled = scheduled,
        createdAt = createdAt,
        updatedAt = updatedAt
)