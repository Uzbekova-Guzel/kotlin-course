package com.guzeluz.kotlincourse.lessons.lesson15.materials

class GetLastMaterial : Materials() {

    fun extractItem(): String {
        val materials = extractMaterials()
        materials.take(materials.lastIndex - 1)
            .forEach {
                addMaterial(it)
            }
        return materials.last()
    }
}