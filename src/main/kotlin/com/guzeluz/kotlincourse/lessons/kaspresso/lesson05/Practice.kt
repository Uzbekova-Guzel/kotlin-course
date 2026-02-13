package com.guzeluz.kotlincourse.lessons.kaspresso.lesson05

import com.guzeluz.kotlincourse.lessons.kaspresso.lesson04.homework.Price
import kotlin.math.min

data class Product(val name: String, val weight: Int, val price: Double)

class Stock {

    private val products = mutableMapOf<Product, Int>()
    private var countProduct = 1

    fun addProduct(product: Product) {
        products[product] = products.getOrDefault(product, 0) + 1
    }

    fun get(product: Product, amount: Int): Int {
        val currentAmount = products.getOrDefault(product, 0)
        val amountToReturn = min(currentAmount, amount)
        products[product] = currentAmount - amountToReturn
        return amountToReturn
    }

    override fun toString(): String {
        return products.map { (product, quantity) ->
            "${product.name} (${product.weight}g): $${product.price} $quantity items"
        }.joinToString("\n")
            .let { "** Stock **\n$it" }
    }

    operator fun invoke(fnc: Stock.() -> Unit) {
        fnc()
    }

    fun addProduct(name: String, weight: Int, price: Double) = addProduct(Product(name, weight, price))

//    infix fun String.weight(weight: Int): Pair<String, Int> {
//        return this to weight
//    }

    infix fun String.x(weight: Int): Pair<String, Int> {
        return this to weight
    }

//    infix fun Pair<String, Int>.by(price: Double) {
//        repeat(countProduct) {
//            addProduct(first, second, price)
//        }
//        countProduct = 1
//    }

    infix fun Pair<String, Int>.x(price: Double) {
        repeat(countProduct) {
            addProduct(first, second, price)
        }
        countProduct = 1
    }


//    operator fun Int.times(name: String): String {
//        countProduct = this
//        return name
//    }

    infix fun Int.x(name: String): String {
        countProduct = this
        return name
    }
}

fun main() {
//    Используя этот код можно наполнить склад продуктами вот в такой форме:
    val stock = Stock()
    stock.addProduct(Product("bread", 200, 30.0))
    stock.addProduct(Product("bread", 200, 30.0))
    stock.addProduct(Product("bread", 200, 30.0))
    stock.addProduct(Product("bread", 250, 38.0))
    stock.addProduct(Product("apple", 1000, 200.0))

//    Добавь invoke, чтобы склад можно было наполнять следующим образом:
    val stock1 = Stock()
    stock1 {
        addProduct(Product("bread", 200, 30.0))
        addProduct(Product("bread", 200, 30.0))
        addProduct(Product("bread", 200, 30.0))
        addProduct(Product("bread", 250, 38.0))
        addProduct(Product("apple", 1000, 200.0))
    }

//    Добавь перегрузку addProduct, чтобы склад можно было наполнять следующим образом:
    val stock2 = Stock()
    stock2 {
        addProduct("bread", 200, 30.0)
        addProduct("bread", 200, 30.0)
        addProduct("bread", 200, 30.0)
        addProduct("bread", 250, 38.0)
        addProduct("apple", 1000, 200.0)
    }

//    Добавь инфиксные функции, чтобы склад можно было наполнять следующим образом:
    val stock3 = Stock()
//    stock3 {
//        "bread" weight 200 by 30.0
//        "bread" weight 200 by 30.0
//        "bread" weight 200 by 30.0
//        "bread" weight 250 by 38.0
//        "apple" weight 1000 by 200.0
//    }

//    Добавь перегрузку оператора умножения и внутренний счётчик-кэш,
//    чтобы можно было добавлять сразу несколько одинаковых позиций:
    val stock4 = Stock()
//    stock4 {
//        3 * "bread" weight 200 by 30.0
//        "bread" weight 250 by 38.0
//        "apple" weight 1000 by 200.0
//    }
//    println(stock4.toString())

//    Исправь код так, чтобы названия функций были одинаковыми, но при этом всё работало:
    val stock5 = Stock()
    stock5 {
        3 x "bread" x 200 x 30.0
        "bread" x 250 x 38.0
        "apple" x 1000 x 200.0
    }
    println(stock5.toString())
}
