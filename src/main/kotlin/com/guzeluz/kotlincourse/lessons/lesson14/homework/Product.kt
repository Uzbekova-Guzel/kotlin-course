package com.guzeluz.kotlincourse.lessons.lesson14.homework

/*
4. Покупка: продукт.
Создайте дата класс для продукта,
который будет представлять продукт в магазине.
У него должны быть свойства “название”, “цена”, “количество”.
 */

data class Product(val name: String, val price: Double, val quantity: Int)

fun main() {
    val bread = Product("HighProtein", 3.50, 3)
    println(bread)
}