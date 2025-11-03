package com.guzeluz.kotlincourse.lessons.lesson16.homework.geometricShapes

import kotlin.math.PI

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double {
        return PI * radius * radius
    }
}
