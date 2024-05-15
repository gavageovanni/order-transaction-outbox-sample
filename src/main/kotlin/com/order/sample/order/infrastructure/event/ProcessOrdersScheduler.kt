package com.order.sample.order.infrastructure.event

import com.order.sample.order.core.order.OrderModule
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Lazy
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@Lazy(false)
class ProcessOrdersScheduler(
    private val orderModule: OrderModule
) {

    private val log = LoggerFactory.getLogger(ProcessOrdersScheduler::class.java)

    @Scheduled(fixedRateString = "5000")
    fun test() {
        log.info("Polling orders to distribute them to the delivery service.")
        orderModule.processOrders()
    }
}