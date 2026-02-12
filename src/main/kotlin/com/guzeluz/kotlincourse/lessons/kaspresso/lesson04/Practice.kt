package com.guzeluz.kotlincourse.lessons.kaspresso.lesson04

import java.math.BigDecimal

class Distance(val meters: Int) {

    operator fun plus(others: Distance): Distance {
        val sum = meters + others.meters
        return Distance(sum)
    }
}

class Score(private var points: Int) {
    operator fun plusAssign(number: Int) {
        points += number
    }

    fun getPoints() = points
}

class Level(val number: Int) {
    operator fun compareTo(other: Level): Int {
        return number.compareTo(other.number)
    }
}

class User(val id: Int, val name: String) {
    override operator fun equals(other: Any?): Boolean {
        if (other !is User) return false
        return id == other.id
    }
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

//Объявить оператор можно не только как функцию-член,
// но также как функцию-расширение:
//operator fun Point.plus(other: Point): Point {
//    return Point(x + other.x, y + other.y)
//}

//Перегрузка унарных операторов:
operator fun BigDecimal.inc() = this + BigDecimal.ONE

class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

//Infix functions

infix fun Int.with(number: Int): Int {
    return "$this$number".toInt()
}

infix fun Int.without(number: Int): Int {
    return "$this".replace("$number", "").toInt()
}

fun main() {
    val distance = Distance(10)
    val otherDistance = Distance(20)
    val sum = distance + otherDistance
    println(sum.meters)

    val score = Score(1)
    score += 3
    println(score.getPoints())

    val uran = Level(236)
    val cesium = Level(674)
    println(uran > cesium)

    val user1 = User(1, "Mike")
    val user2 = User(3, "Misha")
    println(user1 == user2)

    val point1 = Point(10, 20)
    val point2 = Point(30, 40)
    println(point1 + point2)

    var point = Point(1, 2)
    point += Point(3, 4)
    println(point)

    var bd = BigDecimal.ZERO
    println(bd++) //0
    println(++bd) //2

    val person1 = Person("Alice", "Smith")
    val person2 = Person("Bob", "Jhonson")
    println(person1 < person2)

    10.with(20)
    println(10 with 20)

    println(234637 without 3)
}
