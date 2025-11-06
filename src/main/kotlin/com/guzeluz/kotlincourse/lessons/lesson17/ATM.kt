package com.guzeluz.kotlincourse.lessons.lesson17

class ATM(private var pinCode: String) {
    private var balance: Double = 0.0
    private var pinCodeCounter: Int = 0

    fun getBalance(pinCode: String): Double {
        return if (checkPin(pinCode)) {
            return balance
        } else {
            0.0
        }
    }

    fun deposit(pinCode: String, amount: Double) {
        if (checkPin(pinCode) && amount > 0) {
            balance += amount
        }
    }

    private fun checkPin(pinCode: String): Boolean {
        return if (this.pinCode == pinCode) {
            true
        } else {
            println("Неверный пин-код")
            false
        }
    }

    fun withDraw(pinCode: String, amount: Double): Double {
        return if (checkPin(pinCode) && amount > 0) {
            if (balance > amount) {
                balance -= amount
                amount
            } else {
                val balance2 = balance
                balance = 0.0
                balance2
            }
        } else {
            0.0
        }
    }
}
