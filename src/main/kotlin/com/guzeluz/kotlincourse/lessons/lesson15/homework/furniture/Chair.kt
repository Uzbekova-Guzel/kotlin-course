package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture

open class Chair(
    name: String,
    material: String,
    color: String,
    val hasBackrest: Boolean
) : Furniture(name, material, color) {

    fun chairInfo() {
        val backrest = if (hasBackrest) "has backrest" else "without backrest"
        println("Chair '$name' $backrest, made of $material")
    }
}
