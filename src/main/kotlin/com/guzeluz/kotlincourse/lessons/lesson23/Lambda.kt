package com.guzeluz.kotlincourse.lessons.lesson23

// Обычное объявление функции
fun increment(a: Int): Int {
    return a + 1
}

fun main() {

//    Трансформация в анонимную функцию
    // Анонимная функция, присвоенная переменной
    val increment1 = fun(a: Int): Int {
        return a + 1
    }

    println(increment(2))
    println(increment1(2))

//    Трансформация в лямбда выражение
// Лямбда выражение с явно указанным типом
    val increment2: (Int) -> Int = { a ->
        println(a)
        a + 1 //возвращается последняя строка в виде return
    }

//    Упрощение лямбда выражения
// Лямбда выражение с использованием 'it' для однопараметрической лямбды
    val increment3: (Int) -> Int = {
        println(it)
        it + 1 //возвращается последняя строка в виде return
    }

    val result = increment3(8)

//    Ещё большее упрощение
// Лямбда выражение без явного указания типа возвращаемого значения
    val increment4 = { a: Int ->
        a + 1
    }

//    Вызов лямбда выражения с контекстом в Kotlin
    val op = OrderProcessor("my address")
    calculateDeliveryTime2(op, 34)
// или
    op.calculateDeliveryTime2(34)

//    listOf<String>().find { it.isEmpty() }
    val t = { a: String ->
        a.isEmpty()
    }
    listOf<String>().find(t)
}

//Функции с аргументами

//Пример простого метода, где есть один параметр по умолчанию
fun findIndex(text: String, word: String, ignoreCase: Boolean = false): Int {
    return text.indexOf(word, 0, ignoreCase)
}

//Трансформация в анонимную функцию. Значения параметров по умолчанию в анонимных функциях задавать нельзя.
val findIndex1 = fun(text: String, word: String, ignoreCase: Boolean): Int {
    return text.indexOf(word, 0, ignoreCase)
}

//Трансформация в лямбда выражение
val findIndex2: (String, String, Boolean) -> Int = { text, word, ignoreCase ->
    text.indexOf(word, 0, ignoreCase)
}

//Лямбда выражение без явного указания типов параметров, но тип нужно указать при объявлении переменных:
val findIndex3 = { text: String, word: String, ignoreCase: Boolean ->
    println(text)
    text.indexOf(word, 0, ignoreCase)
}

//Лямбда выражения с контекстом в Kotlin

//Шаг 1: Основной класс

//Давайте начнем с создания класса OrderProcessor, который рассчитывает время доставки товара.
//class OrderProcessor(val deliveryAddress: String) {
//    fun calculateDeliveryTime(productId: Int): String {
//        val deliveryTimeDays = when (productId) {
//            in 1..100 -> 3
//            else -> 5
//        }
//        return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
//    }
//}

//Шаг 2: Расширение класса

//Теперь, вынесем функцию calculateDeliveryTime в расширение класса OrderProcessor:
class OrderProcessor(val deliveryAddress: String)

fun OrderProcessor.calculateDeliveryTime(productId: Int): String {
    val deliveryTimeDays = when (productId) {
        in 1..100 -> 3
        else -> 5
    }
    return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
}

//Шаг 3: Анонимная функция

//Преобразуем calculateDeliveryTime в анонимную функцию с контекстом OrderProcessor:
val calculateDeliveryTime1 = fun OrderProcessor.(productId: Int): String {
    val deliveryTimeDays = when (productId) {
        in 1..100 -> 3
        else -> 5
    }
    return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
}

//Шаг 4: Лямбда выражение

//Теперь преобразуем анонимную функцию в лямбда выражение с контекстом. Нельзя опустить тип входящего и возвращаемого значения.
val calculateDeliveryTime2: OrderProcessor.(Int) -> String = {
    val deliveryTimeDays = when (it) {
        in 1..100 -> 3
        else -> 5
    }
    "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
}
