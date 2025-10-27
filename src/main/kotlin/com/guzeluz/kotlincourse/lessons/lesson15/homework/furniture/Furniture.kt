package com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture

import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.chairs.KitchenChair
import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.chairs.OfficeChair
import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.tables.DiningTable
import com.guzeluz.kotlincourse.lessons.lesson15.homework.furniture.tables.WritingTable

open class Furniture(
    val name: String,
    val material: String,
    val color: String
) {
    fun showInfo() {
        println("Furniture: $name, made of $material, color: $color")
    }

    fun move() {
        println("$name can be moved to another place")
    }
}

fun main() {
    val chair = Chair("Basic Chair", "wood", "brown", true)
    val officeChair = OfficeChair("ErgoPro", "metal", "black", true)
    val kitchenChair = KitchenChair("SimpleKitchen", "plastic", "white")
    val writingTable = WritingTable("WorkDesk", "wood", "oak", 3)
    val diningTable = DiningTable("FamilyTable", "glass", "white", 6)
    val wardrobe = Wardrobe("BigWardrobe", "MDF", "beige", 4)

    chair.chairInfo()
    officeChair.officeChairInfo()
    kitchenChair.kitchenChairInfo()
    writingTable.writingTableInfo()
    diningTable.diningTableInfo()
    wardrobe.wardrobeInfo()
}
