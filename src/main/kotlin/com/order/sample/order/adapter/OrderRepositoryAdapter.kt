package com.order.sample.order.adapter

import com.order.sample.order.core.order.Order
import com.order.sample.order.core.order.OrderRepository
import com.order.sample.order.infrastructure.db.OrderModel
import com.order.sample.order.infrastructure.db.SpringOrderRepository
import com.order.sample.order.infrastructure.db.toOrder
import com.order.sample.order.infrastructure.json.JsonMapper
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class OrderRepositoryAdapter(
    private val entityManager: EntityManager,
    private val jsonMapper: JsonMapper
) : OrderRepository {

    @Transactional
    override fun findOrders(): List<Order> {
        val query = entityManager.createNativeQuery("SELECT * FROM \"order\"", OrderModel::class.java)
        val result = query.resultList
        @Suppress("UNCHECKED_CAST")
        return (result as List<OrderModel>).map { it.toOrder() }
    }
}