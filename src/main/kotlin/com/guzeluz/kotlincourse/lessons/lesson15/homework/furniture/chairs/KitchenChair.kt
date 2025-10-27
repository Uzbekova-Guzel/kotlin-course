package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.chairs

import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.Chair

class KitchenChair(
    name: String,
    material: String,
    color: String
) : Chair(name, material, color, true) {

    fun kitchenChairInfo() {
        println("Kitchen chair '$name' is made of $material and has a backrest")
    }
}
