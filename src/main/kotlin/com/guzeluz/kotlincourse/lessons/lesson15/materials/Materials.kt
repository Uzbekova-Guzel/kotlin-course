package com.guzeluz.kotlincourse.lessons.lesson15.materials

abstract class Materials {

    private val materials = mutableListOf<String>()

    fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

fun main() {
    val ordinalNumbers = listOf(
        "first", "second", "third", "fourth", "fifth",
        "sixth", "seventh", "eighth", "ninth", "tenth",
        "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth",
        "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"
    )

    val getFirstMaterial = GetFirstMaterial()
    ordinalNumbers.forEach {
        getFirstMaterial.addMaterial(it)
    }
    println(getFirstMaterial.extractItem())
    println(getFirstMaterial.extractItem())
    println(getFirstMaterial.extractItem())
    println(getFirstMaterial.printContainer())
}