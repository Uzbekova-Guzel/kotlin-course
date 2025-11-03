package com.guzeluz.kotlincourse.lessons.lesson16.homework.animals

open class Animal {
    open fun makeSound() {
        println("This animal makes no sound.")
    }
}

fun main() {
    val animals: List<Animal> = listOf(Dog(), Cat(), Bird(), Animal())

    for (animal in animals) {
        animal.makeSound()
    }
}
