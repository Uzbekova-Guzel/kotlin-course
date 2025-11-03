package com.guzeluz.kotlincourse.lessons.lesson16.homework.geometricShapes

class Square(private val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}
