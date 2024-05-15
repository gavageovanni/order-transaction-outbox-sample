package com.order.sample.order.infrastructure.db

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface SpringOrderRepository : CrudRepository<OrderModel, UUID>