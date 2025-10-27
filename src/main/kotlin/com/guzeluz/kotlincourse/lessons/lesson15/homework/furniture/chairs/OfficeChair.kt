package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.chairs

import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.Chair

class OfficeChair(
    name: String,
    material: String,
    color: String,
    val hasWheels: Boolean
) : Chair(name, material, color, true) {

    fun officeChairInfo() {
        val wheels = if (hasWheels) "has wheels" else "without wheels"
        println("Office chair '$name' $wheels, color: $color")
    }
}
