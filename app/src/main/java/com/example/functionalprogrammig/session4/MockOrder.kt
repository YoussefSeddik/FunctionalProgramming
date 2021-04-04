package com.example.functionalprogrammig.session4


object MockOrder {

    fun mockOrderList() = mutableListOf(
        mockOrder1(),
        mockOrder2(),
        mockOrder3(),
        mockOrder4(),
        mockOrder5(),
        mockOrder6(),
        mockOrder7()
    )

    fun mockOrder1() = Order(mockProduct1())
    fun mockOrder2() = Order(mockProduct2())
    fun mockOrder3() = Order(mockProduct3())
    fun mockOrder4() = Order(mockProduct4())
    fun mockOrder5() = Order(mockProduct5())
    fun mockOrder6() = Order(mockProduct6())
    fun mockOrder7() = Order(mockProduct7())


    fun mockProduct1() = Product("fsafds", 2000.0)
    fun mockProduct2() = Product("fsads", 3000.0)
    fun mockProduct3() = Product("fsafs", 100.0)
    fun mockProduct4() = Product("fsafd", 200.0)
    fun mockProduct5() = Product("fafds", 4300.0)
    fun mockProduct6() = Product("safds", 3400.0)
    fun mockProduct7() = Product("afds", 500.0)

}