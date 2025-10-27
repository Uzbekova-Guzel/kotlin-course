package com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures.polygon

import com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures.Polygon
import kotlin.math.sqrt

class Triangle(
    val a: Double,
    val b: Double,
    val c: Double
) : Polygon("Triangle", 3) {

    fun triangleInfo() {
        println("Triangle with sides: $a, $b, $c")
    }

    fun perimeter() = a + b + c

    fun area(): Double {
        val s = perimeter() / 2
        return sqrt(s * (s - a) * (s - b) * (s - c))
    }
}
