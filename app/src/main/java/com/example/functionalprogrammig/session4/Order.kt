package com.example.functionalprogrammig.session4

data class Order(
    val product: Product,
    var discout: Double = 0.0

)

data class Product(
    val id: String = "",
    val price: Double = 0.0
)