package com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures

import com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures.polygon.Quadrilateral
import com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures.polygon.Triangle

open class GeometricFigure(
    val name: String
) {
    fun showInfo() {
        println("This is a geometric figure: $name")
    }
}

fun main() {
    val triangle = Triangle(3.0, 4.0, 5.0)
    val quadrilateral = Quadrilateral(2.0, 3.0, 2.0, 3.0)
    val circle = Circle(5.0)

    triangle.triangleInfo()
    println("Perimeter: ${triangle.perimeter()}")
    println("Area: ${triangle.area()}")

    quadrilateral.quadrilateralInfo()
    println("Perimeter: ${quadrilateral.perimeter()}")
    println("Area: ${quadrilateral.area()}")

    circle.circleInfo()
    println("Perimeter: ${circle.perimeter()}")
    println("Area: ${circle.area()}")
}
