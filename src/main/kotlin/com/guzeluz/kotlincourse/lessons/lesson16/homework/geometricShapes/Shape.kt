package com.guzeluz.kotlincourse.lessons.lesson16.homework.geometricShapes

abstract class Shape {
    open fun area(): Double {
        return 0.0
    }
}

fun main() {
    val shapes: List<Shape> = listOf(
        Circle(5.0), Square(4.0), Triangle(6.0, 8.0, 30.0)
    )

    for (shape in shapes) {
        println("Shape area: ${"%.2f".format(shape.area())}")
    }
}
