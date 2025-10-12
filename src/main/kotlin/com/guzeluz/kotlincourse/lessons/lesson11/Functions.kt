package com.guzeluz.kotlincourse.lessons.lesson11

//Определение функций

fun sayHello() {
    println("Hello, world!")
}

fun greetUser(name: String) {
    println("Hello, $name!")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int) {
    println("Sum of $a and $b is ${a + b}")
}

//Возвращаемые значения

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun printSum1(a: Int, b: Int) {
    println("Sum of $a and $b is ${a + b}")
}

//Однострочные функции

fun multiply(a: Int, b: Int): Int = a * b

//Модификаторы доступа: public и private

private fun calculateDiscount(price: Double): Double {
    return price * 0.1
}

fun finalPrice(price: Double): Double {
    val discount = calculateDiscount(price)
    return price - discount
}

//Ключевое слово return

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun findValue(numbers: List<Int>, target: Int) {
    for (number in numbers) {
        if (number == target) {
            println("Value found: $number")
            return
        }
    }
    println("Value not found")
}