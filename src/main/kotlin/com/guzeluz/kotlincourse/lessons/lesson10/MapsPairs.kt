package com.guzeluz.kotlincourse.lessons.lesson10

fun main() {
//    Пары значений (Pair)
    val pair = 1 to "a"

//    Словари (Map)
    val emptyMap = mapOf<String, String>()

    val capitals = mapOf("Россия" to "Москва", "Франция" to "Париж")
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")

    val mutableCapitals = mutableMapOf("Россия" to "Москва", "Франция" to "Париж")

    mutableCapitals["Германия"] = "Берлин"
    mutableCapitals.remove("Франция")

//    Примеры работы со словарями
//    Доступ к элементам:
    val capitalOfRussia = capitals["Россия"]

//    Перебор элементов:
    for ((country, capital) in capitals) {
        println("$country: $capital")
    }

//    Условия:
    if ("Россия" in capitals) {
        println("Столица России: ${capitals["Россия"]}")
    }

//    Уникальность ключей
    val map1 = mutableMapOf("a" to 1, "b" to 2)
    map1["a"] = 3  // значение по ключу "a" теперь будет 3, а не 1

//    Ключи и Null
    val mapWithNullableKey = mutableMapOf<String?, Int>(null to 1)

//    Неуникальность значений
    val map2 = mutableMapOf("a" to 1, "b" to 1, "c" to 2)


}




