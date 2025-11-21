package com.guzeluz.kotlincourse.lessons.lesson21.homework

import kotlin.math.pow

/*
Задача 1

Напишите функцию analyzeDataType, принимающую параметр типа Any.
Функция должна определить тип аргумента и вывести соответствующее сообщение:
Для строки: "Это строка: [значение]".
Для любого числа: "Это число: [значение]".
Для списка: "Это список, количество элементов: [количество]".
Для словаря: "Это словарь, количество пар: [количество]".
Для остальных типов: "Неизвестный тип данных".
Используйте оператор is для проверки типов.
 */
fun analyzeDataType(arg: Any?) {
    when (arg) {
        is String -> println("Это строка: $arg")
        is Int -> println("Это число: $arg")
        is List<*> -> println("Это список, количество элементов: ${arg.size}")
        is Map<*, *> -> println("Это словарь, количество пар: ${arg.size}")
        else -> println("Неизвестный тип данных")
    }
}

/*Задача 2

Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
если аргумент можно безопасно привести к типу List.
В случае неудачного приведения функция должна возвращать -1.
Используйте as? для безопасного приведения типа.
 */
fun safeCastToList(arg: Any): Int {
    return (arg as? List<*>)?.size ?: -1
}

/*Задача 3

Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и
возвращает длину строки, если аргумент можно привести к типу String.
В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.
 */
fun getStringLengthOrZero(arg: Any?): Int {
    return (arg as? String)?.length ?: 0
}

/*Задача 4

Создайте функцию-расширение класса Any toSquare.
Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”) и
должна вернуть квадрат этого числа.
Если придёт число, его нужно возвести в квадрат,
если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.
 */
fun Any.toSquare(): Double {
    return (this as? Number)?.toDouble()?.pow(2)
        ?: (this as String).toDouble().pow(2)
}

/*Задача 5

Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и
возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке.
Все остальные типы должны быть проигнорированы.
 */
fun sumIntOrDoubleValues(list: List<Any>): Double {
    var sum = 0.0
    list.forEach {
        if (it is Int) sum += it.toDouble()
        else if (it is Double) sum += it
    }
    return sum
}

fun sumIntOrDoubleValues1(list: List<Any>): Double {
    return list.filter { it is Int || it is Double }
        .sumOf { (it as Number).toDouble() }
}

/*Задача 6

Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и
пытается привести его к типу List<*>.
Если приведение успешно, функция должна напечатать все строки из списка,
если элемент не является строкой, то вывести предупреждение об этом.
Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.
 */
fun tryCastToListAndPrint(arg: Any) {
    println((arg as? List<*>)?.map { (it as? String) ?: "This is not string" }
        ?: "Error message")
}

fun main() {
    analyzeDataType("What is it?")
    analyzeDataType(42)
    analyzeDataType(listOf("Hi", 65, "$$$"))
    analyzeDataType(mapOf(1 to "first", 2 to "second"))
    analyzeDataType(null)

    println(safeCastToList(listOf("Hi", 65, "$$$")))
    println(safeCastToList("Hi"))

    println(getStringLengthOrZero(42))
    println(getStringLengthOrZero("Hello"))

    println(2.toSquare())
    println(2.0.toSquare())
    println("3".toSquare())

    println(sumIntOrDoubleValues(listOf("Hi", 65, "$$$", 2.2)))

    tryCastToListAndPrint(listOf("Hi", 65, "$$$", 2.2))
    tryCastToListAndPrint("Hi")
}
