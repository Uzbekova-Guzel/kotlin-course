package com.guzeluz.kotlincourse.lessons.lesson27

/*
Задание 1.
Создать Enum, который перечисляет времена года.
Добавить в него аргумент, который сохраняет первый месяц для времени года.
Добавить признак “isVariableDuration” для времени года с изменяемой длительностью.
Добавить метод, который выводит информацию о времени года.
Добавить "статический" метод через companion object, который позволит
определить время года по номеру первого месяца и вернуть соответствующий enum.
 */
enum class YearSeasons(val firstMonth: Int, val isVariableDuration: Boolean = false) {
    WINTER(12, true),
    SPRING(3),
    SUMMER(6),
    AUTUMN(9);

    fun seasonInfo() {
        println(name)
    }
}

fun main() {
    YearSeasons.WINTER.seasonInfo()
}