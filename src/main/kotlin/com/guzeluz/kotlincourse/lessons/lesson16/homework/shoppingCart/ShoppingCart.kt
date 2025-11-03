package com.guzeluz.kotlincourse.lessons.lesson16.homework.shoppingCart

class ShoppingCart {
    private val items = mutableMapOf<Int, Int>()

    fun addToCart(itemId: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: Int, amount: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(itemsMap: Map<Int, Int>) {
        for ((id, amount) in itemsMap)
            items[id] = items.getOrDefault(id, 0) + 1
    }

    fun addToCart(itemIds: List<Int>) {
        for (id in itemIds)
            items[id] = items.getOrDefault(id, 0) + 1
    }

    override fun toString(): String {
        if (items.isEmpty()) return "Корзина пуста."

        val totalItems = items.size
        val totalQuantity = items.values.sum()
        val builder = StringBuilder()

        builder.appendLine("Содержимое корзины:")
        builder.appendLine("--------------------------------")
        builder.appendLine(String.format("%-10s | %-10s", "ID товара", "Кол-во"))
        builder.appendLine("--------------------------------")

        for ((id, amount) in items) {
            builder.appendLine(String.format("%-10d | %-10d", id, amount))
        }

        builder.appendLine("--------------------------------")
        builder.appendLine("Всего артикулов: $totalItems")
        builder.appendLine("Всего товаров:   $totalQuantity")

        return builder.toString()
    }
}

fun main() {
    val cart = ShoppingCart()

    cart.addToCart(101)
    cart.addToCart(102)
    cart.addToCart(101)

    cart.addToCart(103, 5)

    cart.addToCart(mapOf(104 to 3, 101 to 2))

    cart.addToCart(listOf(105, 106, 101, 102))

    println(cart)
}
