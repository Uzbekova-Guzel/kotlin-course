package com.guzeluz.kotlincourse.lessons.lesson13

fun main() {
    //Создание и Инициализация
    val fruitsPrices = mapOf("apple" to 2.99, "banana" to 1.99, "cherry" to 3.99)

//Работа с Map.Entry в Kotlin

//Доступ к Элементам Словаря через Map.Entry
    for (entry in fruitsPrices.entries) {
        println("Key: ${entry.key}, Value: ${entry.value}")
    }

    for ((key, value) in fruitsPrices) {
        println("Key: $key, Value: $value")
    }

//    Получение Элементов

//    entries, keys, values
    val entries: Set<Map.Entry<String, Double>> = fruitsPrices.entries
    val keys: Set<String> = fruitsPrices.keys
    val values: Collection<Double> = fruitsPrices.values
    println(entries)
    println(keys)
    println(values)

//    getOrElse, getValue, getOrDefault
    val priceOfPearOrElse = fruitsPrices.getOrElse("pear") { 9999.99 }
    val priceOfApple = fruitsPrices.getValue("apple")
    val priceOfPearOrDefault = fruitsPrices.getOrDefault("pear", 0.0)

//    Изменение состава словаря
    val fruitsWithoutBanana = fruitsPrices - "banana" // создание нового словаря в котором нет "banana"
    val fruitsWithPineapple = fruitsPrices + ("pineapple" to 3.5) // создание нового словаря с дополнительной парой
    val mutableFruits = fruitsPrices.toMutableMap() // Создание нового изменяемого словаря с теми же значениями
    mutableFruits["kiwi"] = 2.75 // Добавление элемента
    mutableFruits.putAll(mapOf("lime" to 1.1, "avocado" to 1.9)) // Добавление словаря
    mutableFruits + mapOf(
        "lime" to 1.1,
        "avocado" to 1.9
    ) // Не добавляет данные в существующий словарь а создаёт новый, в который включены данные из обоих словарей
    mutableFruits.remove("apple") // Удаление элемента
    mutableFruits.clear() // Очистка словаря


//    Проверка наличия элементов
//    containsKey, containsValue, isEmpty, isNotEmpty
    val containsApple = fruitsPrices.containsKey("apple")
    val containsValue1_5 = fruitsPrices.containsValue(1.5)
    val isEmpty = fruitsPrices.isEmpty()
    val isNotEmpty = fruitsPrices.isNotEmpty()
    val areAllFruitsExpensive = fruitsPrices.all { it.value > 1.0 }
    val isAnyFruitCheap = fruitsPrices.any { it.value < 1.0 }

//    Фильтрация и преобразование
//    filter, filterKeys, filterValues, filterNot, count
    val filteredByPrice = fruitsPrices.filter { it.value > 1.0 }
    val filteredByKeys = fruitsPrices.filterKeys { it.startsWith("a") }
    val filteredByValues = fruitsPrices.filterValues { it < 2.0 }
    val filteredNotApple = fruitsPrices.filterNot { it.key == "apple" }
    val countExpensiveFruits = fruitsPrices.count { it.value > 1.5 }

//    map, mapKeys, mapValues
    val increasedPrices: Map<String, Double> = fruitsPrices.mapValues { it.value * 1.1 }
    val fruitNamesUppercase: Map<String, Double> = fruitsPrices.mapKeys { it.key.uppercase() }
    val fruitsList: List<String> = fruitsPrices.map { "${it.key} costs ${it.value}" }

//    Преобразование в Map и MutableMap
    val toMap = mutableFruits.toMap()
    val toMutableMap = fruitsPrices.toMutableMap()

//    Итерация с forEach

//    С использованием деструктуризации
    fruitsPrices.forEach { (fruit, price) ->
        println("$fruit costs $price")
    }

//    С использованием it как объекта Map.Entry
    fruitsPrices.forEach {
        println("${it.key} costs ${it.value}")
    }

//    Размер словаря
//            size и count
    fruitsPrices.size // количество ключей
    fruitsPrices.count() // тоже количество ключей
    fruitsPrices.count { it.value > 2 } // количество ключей если сначала применить фильтрацию по условию

// Practice

    val food = mapOf(
        "Овощи" to listOf("Картофель", "Морковь", "Лук"),
        "Фрукты" to listOf("Яблоки", "Груши", "Апельсины"),
        "Ягоды" to listOf("Виноград", "Клубника", "Голубика"),
        "Орехи" to listOf("Арахис", "Фундук", "Макадамия"),
        "Зелень" to listOf(),
    )

    val a1: List<String>? = food["Овощи"]

    for (entry in food) {
        println("Key: ${entry.key}\nValue: ${entry.value}")
    }

    food.forEach {
        println("Key: ${it.key}\nValue: ${it.value}")
    }

    val a2: List<String> = food.getValue("Фрукты")

    val a3: List<String> = food.getOrDefault("Крупы", listOf())

    val a4: List<String> = food.getOrElse("Рыба") {
        println("Ключ не найден")
        listOf()
    }

    if (!food.containsKey("Мясо") && !food.containsKey("Рыба")) {
        println("Это еда вегетарианца")
    }

    val a5 = food.map { "${it.key} ${it.value}" }
}
