package com.guzeluz.kotlincourse.lessons.lesson05

fun main() {
    val userLang: String? = "Italian"
    val defaultLang = "English"
    val currentLang = userLang ?: defaultLang
    println(currentLang)

    val innerAccumulator = 5000
    val externalAccumulator: Int? = 2000
    val powerBank = innerAccumulator + (externalAccumulator ?: 0)

    val goodsInContainer: String? = null
    val checkedGoods = goodsInContainer ?: "Goods not found"

    val price = 80.0
    val discountInPercent: Double? = null
    val discount = (discountInPercent ?: 0.0) / 100
    val discountPrice = price - price * discount
}
