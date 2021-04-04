package com.example.functionalprogrammig.session7

fun main() {
    val q10 = test(10.0)
    println(q10(4.0))

    val q20 = test(20.0)
    println(q20(4.0))

    class EmployeeSalary(val segment: String, val salary: Double)
    class GrossCalc(val segment: String, val grossCalc: (a: Double) -> Double)

    val employeeList = mutableListOf<EmployeeSalary>(
        EmployeeSalary("a", 1000.0),
        EmployeeSalary("b", 2000.0),
        EmployeeSalary("c", 3000.0)
    )

    val grossCalculators: MutableList<GrossCalc> =
        employeeList.map { GrossCalc(it.segment, calcGrossSalary(it.salary)) }.toMutableList()

    println(grossCalculators.first().grossCalc(80.0))
    println(grossCalculators[1].grossCalc(90.0))
    println(grossCalculators.first { it.segment == "c" }.grossCalc(100.0))


}

fun test(x: Double): (a: Double) -> Double {
    val x1 = x + 10
    return {
        it + x1
    }
}

fun calcGrossSalary(basicSalary: Double): (a: Double) -> Double {
    val tax = .2 * basicSalary
    return { bonus ->
        bonus + tax + basicSalary
    }
}