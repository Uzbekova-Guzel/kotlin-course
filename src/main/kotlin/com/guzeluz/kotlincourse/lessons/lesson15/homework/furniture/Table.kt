package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture

open class Table(
    name: String,
    material: String,
    color: String,
    val shape: String
) : Furniture(name, material, color) {

    fun tableInfo() {
        println("Table '$name' has $shape shape")
    }
}
