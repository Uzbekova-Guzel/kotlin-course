package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.tables

import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.Table

class DiningTable(
    name: String,
    material: String,
    color: String,
    val seats: Int
) : Table(name, material, color, "round") {

    fun diningTableInfo() {
        println("Dining table '$name' fits $seats people")
    }
}
