package com.order.sample.order.core.order

interface OrderRepository {
    fun findOrders(): List<Order>
}