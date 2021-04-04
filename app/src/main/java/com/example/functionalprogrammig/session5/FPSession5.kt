package com.example.functionalprogrammig.session5


fun main() {
    val data = mutableListOf(3.0, 5.0, 7.0, 8.0)
    val newList = data.map {
        addOneSquareSubtractTen().invoke(it)
    }
    newList.forEach {
        println(it)
    }
}

fun <T1, T2, T3> ((T1) -> T2).compose(t2: (T2) -> T3): (T1) -> T3 {
    return {
        t2(this(it))
    }
}

fun addOneSquareSubtractTen(): (x: Double) -> Double = addOne()
    .compose(square()).compose(
    subtractTen()
)

fun addOne(): (x: Double) -> Double {
    return {
        it + 1
    }
}

fun subtractTen(): (x: Double) -> Double {
    return {
        it - 10
    }

}

fun square(): (x: Double) -> Double {
    return {
        it * it
    }
}