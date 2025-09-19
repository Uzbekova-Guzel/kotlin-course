package com.guzeluz.kotlincourse.lessons.lesson06

fun main() {

    val number = 10
    if (number > 5) {
        println("Число больше 5")
    }

    if (number % 2 == 0) {
        println("Число четное")
    } else {
        println("Число нечетное")
    }

    if (number < 0) {
        println("Число отрицательное")
    } else if (number == 0) {
        println("Число равно 0")
    } else {
        println("Число положительное")
    }

    val a = 5
    val b = 6
    val max = if (a > b) a else b

    val intRange = 1..10
    val intRangeUntil = 1 until 10
    val downTo = 10 downTo 1
    val charRange = 'd'..'r'

    val inRange = 2 in intRange
    val notInRange = 2 !in intRange

    val score = 95
    when (score) {
        2, 3, 5 -> println("ok")
        in listOf(2, 3, 5) -> println("Great!")
        in 90..100 -> println("Отлично")
        in 80..89 -> println("Хорошо")
        in 70..79 -> println("Удовлетворительно")
        else -> println("Нужно подучить")
    }

    val result = when (score) {
        in 90..100 -> "Отлично"
        in 80..89 -> "Хорошо"
        in 70..79 -> "Удовлетворительно"
        else -> "Нужно подучить"
    }
    println(result)
}

//Задание 1
//Напишите функцию, которая принимает текущий час (число от 0 до 23) и
// печатает строку с названием времени суток (утро, день, вечер, ночь).

fun definePartOfDay(time: Int) {
    if (time in 0..4) {
        println("Night")
    } else if (time in 5..12) {
        println("Morning")
    } else if (time in 13..17) {
        println("Afternoon")
    } else if (time in 18..23) {
        println("Evening")
    } else {
        println("There is only 12 ours in the day")
    }
//    or
    when (time) {
        in 0..4 -> println("Night")
        in 5..12 -> println("Morning")
        in 13..17 -> println("Afternoon")
        in 18..23 -> println("Evening")
        else -> println("There is only 12 ours in the day")
    }
}

//Задание 2
//Напишите функцию, которая принимает число (балл от 0 до 100) и
// печатает соответствующую оценку (A, B, C, D, E, F) в соответствии со школьной системой оценивания.

fun scoreInSchool(count: Int): Char {
    val result = when (count) {
        in 90..100 -> 'A'
        in 80 until 90 -> 'B'
        in 65 until 80 -> 'C'
        in 50 until 65 -> 'D'
        in 35 until 50 -> 'E'
        in 0 until 35 -> 'F'
        else -> '!'
    }
    return result
}

//Задание 4
//Создайте функцию, которая на основе текущей температуры воздуха (в градусах Цельсия) и
// наличия осадков (булево значение, где true - идёт дождь или снег) рекомендует,
// какой вид транспорта лучше использовать: "Автомобиль", "Велосипед", "Общественный транспорт" или "Прогулка".
// Автомобиль следует выбирать в самый холод и самую жару.
// Велосипед и прогулку не стоит выбирать во время осадков.

fun transportRecommendation(temperature: Int, rain: Boolean) {
    if (temperature > 30 || temperature < -5) {
        if (rain) {
            println("Stay at home")
        } else {
            println("Take a car!")
        }
    } else if (temperature >= 15 && !rain) {
        println("Take a walk")
    } else {
        println("Go to the bus station")
    }
}
