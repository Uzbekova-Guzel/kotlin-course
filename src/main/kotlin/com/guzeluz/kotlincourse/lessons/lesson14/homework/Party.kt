package com.guzeluz.kotlincourse.lessons.lesson14.homework

/*
1. Событие: вечеринка.
Создайте класс Party, который описывает вечеринку.
У него должны быть свойства location (String) и attendees (Int).
Добавьте метод details(), который выводит информацию
о месте проведения и количестве гостей.
 */

class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Location: $location\nAttendees count: $attendees")
    }
}

fun main() {
    val party = Party("Mars", 350)
    party.details()
}