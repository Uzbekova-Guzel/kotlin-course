package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture

class Wardrobe(
    name: String,
    material: String,
    color: String,
    val doors: Int
) : Furniture(name, material, color) {

    fun wardrobeInfo() {
        println("Wardrobe '$name' has $doors doors")
    }
}
