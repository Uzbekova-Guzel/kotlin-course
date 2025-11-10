package com.guzeluz.kotlincourse.lessons.lesson17.homework

class SlotMachine(
    val color: String,
    val model: String,
    val joystick: Boolean,
    val owner: String,
    private var pinCode: String
) {
    private var isOn: Boolean = false
    private var isOSloaded: Boolean = false
    var phone: String = "+49000000"
        private set
    private val games: List<String> = listOf("GTA-5", "Match3")
    private var balance: Double = 0.0
    private var isSessionPaid: Boolean = false
    var sessionPrice: Double = 10.0
        private set

    fun turnOn() {
        isOn = true
        loadOS()
    }

    fun turnOff() {
        offOS()
        isOn = false
    }

    private fun loadOS() {
        isOSloaded = true
    }

    private fun offOS() {
        isOSloaded = false
    }

    fun showGames(): List<String> = games


    fun turnOnGame(name: String): Boolean {
        return if (name in games && isOn && isOSloaded && isSessionPaid) {
            println("$name запущена")
            isSessionPaid = false
            true
        } else {
            println("Не удалось запустить игру. Проверьте оплату или состояние автомата.")
            false
        }
    }

    fun paySession(amount: Double) {
        if (amount >= sessionPrice) {
            balance += amount
            isSessionPaid = true
        } else {
            println("Недостаточно средств для оплаты сеанса.")
        }
    }

    fun getMoney(pinCode: String): Double {
        return if (this.pinCode == pinCode) {
            balance
        } else {
            println("Неверный пин-код")
            0.0
        }
    }

    private fun openSafeForCash(): Double {
        val cash = balance
        balance = 0.0
        return cash
    }
}

fun main() {
    val slotMachine = SlotMachine(
        color = "Red",
        model = "SuperSlot 3000",
        joystick = true,
        owner = "Arcade GmbH",
        pinCode = "1234"
    )

    slotMachine.turnOnGame("GTA-5") //Не удалось запустить игру. Проверьте оплату или состояние автомата.
    slotMachine.turnOn()
    println("Список игр: ${slotMachine.showGames()}")
    slotMachine.turnOnGame("Match3")//Не удалось запустить игру. Проверьте оплату или состояние автомата.
    slotMachine.paySession(10.0)
    slotMachine.turnOnGame("Match3")
    slotMachine.getMoney("0000")//Неверный пин-код
    slotMachine.getMoney("1234")
    slotMachine.turnOff()
}
