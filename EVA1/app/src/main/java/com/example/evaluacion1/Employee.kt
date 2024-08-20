package com.example.evaluacion1

open class Employee(val name: String, val salary: Double)

class HonoraryEmployee(name: String, salary: Double) : Employee(name, salary) {
    fun calculateNetPayment(): Double {
        return salary * 0.87 // 13% retención
    }
}

class ContractEmployee(name: String, salary: Double) : Employee(name, salary) {
    fun calculateNetPayment(): Double {
        return salary * 0.80 // 20% retención
    }
}
