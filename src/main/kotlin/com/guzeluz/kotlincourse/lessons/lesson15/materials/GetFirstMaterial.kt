package com.guzeluz.kotlincourse.lessons.lesson15.materials

class GetFirstMaterial : Materials() {

    fun extractItem(): String {
        val materials = extractMaterials()
        materials.drop(1).forEach {
            addMaterial(it)
        }
        return materials.first()
    }
}