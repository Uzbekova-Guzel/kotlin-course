package com.guzeluz.kotlincourse.lessons.lesson23.homework

import kotlin.collections.groupingBy

/*1. Создай функцию, которая принимает список чисел и
 возвращает среднее арифметическое всех чётных чисел этого списка.
 С помощью require проверь, что список не пустой.
    1.1. Создай аналогичную анонимную функцию.
    1.2. Создай аналогичное лямбда выражение с указанием типа.
    1.3. Создай лямбда выражение без указания типа.
    1.4. Проверь, что лямбда выражение работает правильно с
    помощью нескольких наборов данных (в том числе пустого). */
fun getEvenAverage(numbers: List<Int>): Double {
    require(numbers.isNotEmpty())
    return numbers.filter { it % 2 == 0 }
        .average()
}

val getEvenAverage1 = fun(numbers: List<Int>): Double {
    require(numbers.isNotEmpty())
    return numbers.filter { it % 2 == 0 }
        .average()
}

val getEvenAverage2: (List<Int>) -> Double = { numbers ->
    require(numbers.isNotEmpty())
    numbers.filter { it % 2 == 0 }
        .average()
}

val getEvenAverage3 = { numbers: List<Int> ->
    require(numbers.isNotEmpty())
    numbers.filter { it % 2 == 0 }
        .average()
}

/*2. Создай функцию, которая принимает большое число и
 возвращает сумму цифр этого числа.
 Сделай проверку, что входящее число больше нуля.
 Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
    2.1. Создай аналогичную анонимную функцию.
    2.2. Создай аналогичное лямбда выражение с указанием типа.
    2.3. Создай лямбда выражение без указания типа.
    2.4. Проверь, что лямбда выражение работает правильно с
     помощью нескольких наборов данных.*/
fun getSum(num: Long): Int {
    require(num > 0) { "Number must be more than zero" }
    return "$num".sumOf { it.digitToInt() }
}

val getSum1 = fun(num: Long): Int {
    require(num > 0) { "Number must be more than zero" }
    return "$num".sumOf { it.digitToInt() }
}

val getSum2: (Long) -> Int = { num ->
    require(num > 0) { "Number must be more than zero" }
    "$num".sumOf { it.digitToInt() }
}

val getSum3 = { num: Long ->
    require(num > 0) { "Number must be more than zero" }
    "$num".sumOf { it.digitToInt() }
}

/*3. Создай функцию-расширение списка чисел,
 которая будет возвращать множество дубликатов чисел
 (встречающихся в списке более одного раза).
3.1. Создай аналогичную анонимную функцию.
3.2. Создай аналогичное лямбда выражение с указанием типа.
3.3. Проверь, что лямбда выражение работает правильно с
 помощью нескольких наборов данных.*/
fun List<Int>.getSetOfDuplicates(): Set<Int> {
    return groupingBy { it }
        .eachCount()
        .filterValues { it > 1 }
        .keys
}

val getSetOfDuplicates1 = fun List<Int>.(): Set<Int> {
    return groupingBy { it }
        .eachCount()
        .filterValues { it > 1 }
        .keys
}

val getSetOfDuplicates2: List<Int>.() -> Set<Int> = {
    groupingBy { it }
        .eachCount()
        .filterValues { it > 1 }
        .keys
}

fun main() {
    //1
    println(
        try {
            getEvenAverage(listOf())
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getEvenAverage(listOf(1, 2, 3, 4)))
    println(getEvenAverage(listOf(2, 4, 6, 8)))
    println(getEvenAverage(listOf(1, 3, 5, 7)))

    println(
        try {
            getEvenAverage1(listOf())
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getEvenAverage1(listOf(1, 2, 3, 4)))
    println(getEvenAverage1(listOf(2, 4, 6, 8)))
    println(getEvenAverage1(listOf(1, 3, 5, 7)))

    println(
        try {
            getEvenAverage2(listOf())
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getEvenAverage2(listOf(1, 2, 3, 4)))
    println(getEvenAverage2(listOf(2, 4, 6, 8)))
    println(getEvenAverage2(listOf(1, 3, 5, 7)))

    println(
        try {
            getEvenAverage3(listOf())
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getEvenAverage3(listOf(1, 2, 3, 4)))
    println(getEvenAverage3(listOf(2, 4, 6, 8)))
    println(getEvenAverage3(listOf(1, 3, 5, 7)))

    //2
    println(
        try {
            getSum(0)
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getSum(23426746263762))

    println(
        try {
            getSum1(0)
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getSum1(23426746263762))

    println(
        try {
            getSum2(0)
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getSum2(23426746263762))

    println(
        try {
            getSum3(0)
        } catch (e: Exception) {
            println(e.message)
        }
    )
    println(getSum3(23426746263762))

    //3
    println(listOf(1, 2, 2, 3, 3, 3).getSetOfDuplicates())
    println(listOf(1, 2, 2, 3, 3, 3).getSetOfDuplicates1())
    println(listOf(1, 2, 2, 3, 3, 3).getSetOfDuplicates2())
}
