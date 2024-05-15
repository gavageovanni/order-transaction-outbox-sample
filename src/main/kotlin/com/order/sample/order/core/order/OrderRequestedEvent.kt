package com.order.sample.order.core.order

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class OrderRequestedEvent @JsonCreator constructor(
        @JsonProperty("id") val id: String,
        @JsonProperty("orderId") val orderId: UUID,
        @JsonProperty("productId") val customerId: UUID,
)