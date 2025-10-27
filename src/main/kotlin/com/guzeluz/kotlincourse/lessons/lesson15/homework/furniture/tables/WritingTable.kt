package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.tables

import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.Table

class WritingTable(
    name: String,
    material: String,
    color: String,
    val drawers: Int
) : Table(name, material, color, "rectangular") {

    fun writingTableInfo() {
        println("Writing table '$name' has $drawers drawers")
    }
}
