package com.guzeluz.kotlincourse.lessons.lesson15.homework.geometricFigures

open class Polygon(
    name: String,
    val sides: Int
) : GeometricFigure(name) {

    fun showPolygonInfo() {
        println("This is a polygon with $sides sides")
    }
}
