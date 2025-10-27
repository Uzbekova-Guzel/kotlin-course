package com.guzeluz.kotlincourse.lessons.lesson14

fun main() {
    val reservedSeatCarriage = Carriage(48)
    val compartmentCarriage = Carriage(16, "Купе")
    val train = Train("Electric locomotive")
    train.carriages.add(reservedSeatCarriage)
    train.carriages.add(compartmentCarriage)
    val passengerAlexandr = Passenger("Alexandr", "02.10.1983", "")
    train.boardPassenger(passengerAlexandr, 10, "Купе")

    Logger.log("Application started")

    val result = Calculator.add(5, 3)
    println("Result: $result")

    val user1 = User(1, "Alice")
    val user2 = user1.copy(name = "Bob")
    println(user1) // Output: User(id=1, name=Alice)
    println(user2) // Output: User(id=1, name=Bob)
}

//Object
//object в Kotlin используется для создания синглтонов, то есть классов, которые могут иметь только один экземпляр.
//Это удобно, когда вам нужен глобальный объект, например, менеджер конфигурации или логгер.

object Logger {
    fun log(message: String) {
        println("Log: $message")
    }
}

//Companion object
//Если вам необходимо создать что-то похожее на статическое поле или метод (как в Java),
//в Kotlin используется companion object.
//Он позволяет объявить статические методы и переменные,
//которые принадлежат самому классу, а не конкретному его экземпляру:

class Calculator {
    companion object {
        fun add(a: Int, b: Int): Int {
            return a + b
        }
    }
}

//Data class
//data class — это специальный вид классов в Kotlin,
//который предназначен для хранения данных.
//Они автоматически предоставляют полезные функции,
//такие как toString(), equals(), hashCode(), и copy(). Пример:

data class User(val id: Int, val name: String)
