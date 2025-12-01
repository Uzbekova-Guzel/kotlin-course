package com.guzeluz.kotlincourse.lessons.lesson23.homework

//1. Создай функцию, которая принимает список чисел и
// возвращает среднее арифметическое всех чётных чисел этого списка.
// С помощью require проверь, что список не пустой.
fun example01(list: List<Int>): Double {
    require(list.isNotEmpty())
    return list.filter { it % 2 == 0 }
        .average()
}

//2. Создай функцию, которая принимает большое число и
// возвращает сумму цифр этого числа.
// Сделай проверку, что входящее число больше нуля.
// Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
fun example02(bigNumber: Long): Int {
    require(bigNumber > 0) { "Число должно быть больше нуля" }
    return "$bigNumber".sumOf { it.digitToInt() }
}

fun main() {
    //1.1. Создай аналогичную анонимную функцию.
    val e1 = fun(list: List<Int>): Double {
        require(list.isNotEmpty())
        return list.filter { it % 2 == 0 }
            .average()
    }

    //1.2. Создай аналогичное лямбда выражение с указанием типа.
    val e11: (List<Int>) -> Double = { list ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }
            .average()
    }

    //1.3. Создай лямбда выражение без указания типа.
    val e111 = { list: List<Int> ->
        require(list.isNotEmpty())
        list.filter { it % 2 == 0 }
            .average()
    }

    //1.4. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).
    val list1 = listOf<Int>()
    val list2 = listOf(1)
    val list3 = listOf(1, 2, 3, 4, 5, 6)
    println(e111(list3))


    //2.1. Создай аналогичную анонимную функцию.
    val e2 = fun(bigNumber: Long): Int {
        require(bigNumber > 0) { "Число должно быть больше нуля" }
        return "$bigNumber".sumOf { it.digitToInt() }
    }

    //2.2. Создай аналогичное лямбда выражение с указанием типа.
    val e22: (Long) -> Int = { number ->
        require(number > 0) { "Число должно быть больше нуля" }
        "$number".sumOf { it.digitToInt() }
    }

    //2.3. Создай лямбда выражение без указания типа.
    val e222 = { number: Long ->
        require(number > 0) { "Число должно быть больше нуля" }
        "$number".sumOf { it.digitToInt() }
    }

    //2.4. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
//3. Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
//3.1. Создай аналогичную анонимную функцию.
//3.2. Создай аналогичное лямбда выражение с указанием типа.
//3.3. Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
}
