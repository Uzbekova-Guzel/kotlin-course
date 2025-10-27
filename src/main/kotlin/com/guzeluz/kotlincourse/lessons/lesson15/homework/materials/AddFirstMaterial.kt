package com.guzeluz.kotlincourse.lessons.lesson15.homework.materials

class AddFirstMaterial : Materials() {
    fun addFirstMaterial(material: String) {
        addMaterial(material)
        val materials = extractMaterials()
        materials.forEach {
            addMaterial(it)
        }
    }
}
