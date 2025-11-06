package com.guzeluz.kotlincourse.lessons.lesson17

//Инкапсуляция в Kotlin
//Private: Члены класса доступны только внутри этого класса.
//Protected: Члены класса доступны внутри класса и в производных классах.
//Internal: Члены класса доступны в любом месте того же модуля.
//Public: Члены класса доступны отовсюду, где есть доступ к классу.

class Account(private var balance: Double) {

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
        }
    }

    fun getBalance(): Double {
        return balance
    }
}

fun main() {

    val account = Account(0.0)
    account.deposit(15.0)
    println("Текущий баланс ${account.getBalance()}")
}