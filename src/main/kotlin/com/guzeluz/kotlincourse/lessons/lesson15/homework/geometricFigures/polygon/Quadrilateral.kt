package com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures.polygon

import com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures.Polygon

class Quadrilateral(
    val a: Double,
    val b: Double,
    val c: Double,
    val d: Double
) : Polygon("Quadrilateral", 4) {

    fun quadrilateralInfo() {
        println("Quadrilateral with sides: $a, $b, $c, $d")
    }

    fun perimeter() = a + b + c + d

    fun area() = a * b
}
