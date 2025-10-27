package com.guzeluz.kotlincourse.lessons.lesson15.materials

class GetMiddleMaterial : Materials() {

    fun extractItem(): String {
        val materials = extractMaterials()
        val middleIndex = materials.size / 2
        for (it in materials.indices) {
            if (it == middleIndex) continue
            addMaterial(materials[it])
        }
        return materials[middleIndex]
    }
}