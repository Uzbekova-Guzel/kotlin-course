package com.guzeluz.kotlincourse.lessons.lesson16.homework.geometricShapes

import kotlin.math.sin

class Triangle(
    private val sideA: Double, private val sideB: Double, private val angleDegrees: Double
) : Shape() {
    override fun area(): Double {
        val angleRadians = Math.toRadians(angleDegrees)
        return 0.5 * sideA * sideB * sin(angleRadians)
    }
}
