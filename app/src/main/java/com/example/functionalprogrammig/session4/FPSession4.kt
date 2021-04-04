package com.example.functionalprogrammig.session4

import com.example.functionalprogrammig.session4.MockOrder.mockOrderList


fun main() {
    val orderList = mockOrderList()
    orderList.map {
        getOrderWithDiscount(it, getDiscountRoles())
    }
}

fun getOrderWithDiscount(
        order: Order,
        roles: MutableList<Pair<(order: Order) -> Boolean, (order: Order) -> Double>>
): Order {
    val discount = roles.asSequence().filter {
        it.first(order)
    }.map {
        it.second(order)
    }.sorted().take(2).average()
    return order.apply {
        discout = discount
    }
}

fun getDiscountRoles(): MutableList<Pair<(order: Order) -> Boolean, (order: Order) -> Double>> {
    return mutableListOf(
            Pair(isAQualified(), a()),
            Pair(isBQualified(), b()),
            Pair(isCQualified(), c())

    )
}

fun a(): (order: Order) -> Double {
    return {
        it.product.price - 20
    }
}

fun b(): (order: Order) -> Double {
    return {
        it.product.price - 30
    }
}

fun c(): (order: Order) -> Double {
    return {
        it.product.price - 40
    }
}


fun isAQualified(): (order: Order) -> Boolean {
    return {
        it.product.price > 2000.0
    }
}

fun isBQualified(): (order: Order) -> Boolean {
    return {
        it.product.price < 2000.0
    }
}

fun isCQualified(): (order: Order) -> Boolean {
    return {
        it.product.price == 2000.0
    }
}