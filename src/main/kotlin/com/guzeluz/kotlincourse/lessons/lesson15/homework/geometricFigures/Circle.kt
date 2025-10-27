package com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures

import kotlin.math.PI

class Circle(
    val radius: Double
) : GeometricFigure("Circle") {

    fun circleInfo() {
        println("Circle with radius $radius")
    }

    fun perimeter() = 2 * PI * radius

    fun area() = PI * radius * radius
}
