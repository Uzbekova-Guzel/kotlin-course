package com.guzeluz.kotlincourse.lessons.lesson22

import java.io.IOException

fun main() {
//    throw Error("")
//    OutOfMemoryError()
//    StackOverflowError()
//    Exception()
//    IOException()
//    RuntimeException()

//    Синтаксис выбрасывания исключений
    throw Exception("Сообщение об ошибке")

// можно выкидывать исключение из переменной
    val exception = Exception("Сообщение об ошибке")
    throw exception

//    Синтаксис отлова исключений
    try {
        // Код, который может выбросить исключение
        arrayOf("1")[2]
        return
    } catch (e: IndexOutOfBoundsException) {
        // Обработка конкретного типа исключения
        println(e.message)
    } catch (e: Exception) {
        // Обработка всех остальных исключений
        println(e)
    } finally {
        // Блок, который выполняется всегда, независимо от наличия исключения
        println("Выполняется в любом случае")
    }

//    Отлов исключений нескольких типов
    try {
        // Код, который может выбросить исключения
    } catch (e: Exception) {
        when (e) {
            is IndexOutOfBoundsException -> {
                println("Обработано исключение типа IndexOutOfBoundsException")
            }

            is RuntimeException -> {
                println("Обработано исключение типа RuntimeException")
            }

            else -> throw e // Перебрасываем исключение дальше, если оно не соответствует обработанным типам
        }
    }

    try {
        placeOrder("") // Попытка оформить заказ с пустыми деталями
    } catch (e: OrderException) {
        println("Ошибка при оформлении заказа: ${e.message}")
    }

}

//Создание собственных типов исключений
class OrderException(message: String) : RuntimeException(message)

//Использование собственного исключения
fun placeOrder(orderDetails: String) {
    if (orderDetails.isBlank()) {
        throw OrderException("Детали заказа не указаны.")
    }
    // Логика оформления заказа
    println("Заказ оформлен: $orderDetails")
}

//при создании собственных исключений, можно использовать
// сразу набор из конструкторов
class CustomException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}
