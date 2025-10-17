package com.guzeluz.kotlincourse.lessons.lesson12

fun main() {

    val numbers = listOf(-1, 2, -3, 4, -5, 8, 264)

//    Итерация коллекции через forEach

    val positive = mutableListOf<Int>()

    for (i in numbers) {
        val isPositive = i > 0
        if (isPositive) {
            positive.add(i)
        }
    }
    numbers.forEach {
        // it - это специальная переменная в Kotlin для
        // хранения значения коллекции из текущей итерации
        val isPositive = it > 0
        if (isPositive) {
            positive.add(it)
        }
    }

//    Фильтрация коллекций
//            filter

    val list = listOf(8, 56, 23, 87, 12, 18, 11)
    val filtered1 = filter(list)
    println(filtered1)

    val filtered2 = list.filter {
        it in 7..17
    }
    println(filtered2)

    val positiveNumbers = numbers.filter { it > 0 }
    println(positiveNumbers) // Вывод: [2, 4]

//    filterNot

    val notPositiveNumbers = numbers.filterNot { it > 0 }
    println(notPositiveNumbers) // Вывод: [-1, -3, -5]

//    filterNotNull

    val nullableList = listOf(1, null, 2, null, 3)
    val nonNullList = nullableList.filterNotNull()
    println(nonNullList) // Вывод: [1, 2, 3]


//    Получение первого или последнего элемента коллекции

    val setOfNumbers = setOf(3, 4, 5, -5, 14)
    val firstElement = setOfNumbers.last()
    val lastElement = setOfNumbers.last()
    println(firstElement)
    println(lastElement)

//    Получение элемента с условием, что его может не быть
//    firstOrNull, lastOrNull и getOrElse

    val firstPositive = numbers.firstOrNull { it > 0 }
    println(firstPositive) // Вывод: 2
    val nullable = numbers.firstOrNull { it > 1000 }
    println(nullable) // Вывод: null
    val elementOrElse = numbers.getOrElse(10) { -1 }
    println(elementOrElse) // Вывод: -1

//    Преобразование коллекций
//            map

    val incrementedNumbers = numbers.map { it + 1 }
    println(incrementedNumbers) // Вывод: [0, 3, -2, 5, -4]

//    associate

    val numberSquareMap = numbers.associate { it to it * it }
    println(numberSquareMap) // Вывод: {-1=1, 2=4, -3=9, 4=16, -5=25}

//    flatten

    val multipleList = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6)
    )
    val flattenList = multipleList.flatten()
    println(flattenList)

//    flatMap

    val flattenListAfterMapping = multipleList.flatMap { list ->
        list.map { it * 2 }
    }
    println(flattenListAfterMapping)

//    joinToString

    val numbersString = numbers.joinToString(separator = " : ")
    println(numbersString) // Вывод: "-1, 2, -3, 4, -5"

//    Сортировка Коллекций
//            sorted

    val sortedNumbers = numbers.sorted()
    println(sortedNumbers) // Вывод: [-5, -3, -1, 2, 4]

//    sortedDescending

    val sortedDescendingNumbers = numbers.sortedDescending()
    println(sortedDescendingNumbers) // Вывод: [4, 2, -1, -3, -5]

//    Длина коллекции

    println(numbers.size)

//    Проверка коллекции
//            isEmpty

    if (numbers.isEmpty()) {
        println("Коллекция пуста")
    } else {
        println("В коллекции ${numbers.size} значений")
    }

//    isNotEmpty

//    contains

    if (numbers.contains(42)) {
        println("Коллекция содержит ответ на главный вопрос")
    } else {
        println("В коллекции нет ответа на главный вопрос")
    }

    if (42 in numbers) {
        println("Коллекция содержит ответ на главный вопрос")
    } else {
        println("В коллекции нет ответа на главный вопрос")
    }


//    containsAll

    if (setOfNumbers.containsAll(listOf(4, 3))) {
        println("Коллекция содержит числа 4 и 3, при этом порядок не имеет значения")
    } else {
        println("В коллекции нет одного из чисел либо всех проверяемых чисел")
    }

//    Другие полезные методы
//    sum

    val sumOfNumbers = numbers.sum()
    println(sumOfNumbers) // Вывод: -3

//    average

    val averageOfNumbers = numbers.average()
    println(averageOfNumbers) // Вывод: -0.6

//    maxOrNull и minOrNull

    val maxNumber = numbers.maxOrNull()
    println(maxNumber) // Вывод: 4
    val minNumber = numbers.minOrNull()
    println(minNumber) // Вывод: -5

//    groupBy

    val groupedBySign = numbers.groupBy { if (it > 0) "Positive" else "Negative" }
    println(groupedBySign) // Вывод: {"Negative"=[-1, -3, -5], "Positive"=[2, 4]}

//    distinct

    val distinctNumbers = listOf(1, 2, 2, 3, 3, 3, 4).distinct()
    println(distinctNumbers) // Вывод: [1, 2, 3, 4]

//    take

    println(numbers.take(3)) // Вывод: [1, 2, 3]

//    takeLast

    println(numbers.takeLast(3)) // Вывод: [3, 4, 5]

//    drop

    println(numbers.drop(2)) // [-3, 4, -5, 8, 264]

//    Practice

    val example = listOf(1, 2, 3, 4, 5)

    example.size
    example.isNotEmpty()
    example.getOrElse(80) { 5 }
    example.joinToString { " " }
    example.sum()
    example.firstOrNull() { it < 0 }
    example.contains(6)
    example.filter { it in 18..30 }
    example.filterNotNull()

    val text = listOf("one", "two", "three", "four", "five")

    val a = text.map { it.length }
    println(a)

    val b = text.associate { it to it.reversed() }
    println(b)

    val d = text.sorted()
    println(d)

    val e = example.forEach {
        println(it * it)
    }

    val f = text.groupBy { it.first() }
    println(f)
}

fun filter(collection: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (i in collection) {
        if (i in 7..17) result.add(i)
    }
    return result
}
