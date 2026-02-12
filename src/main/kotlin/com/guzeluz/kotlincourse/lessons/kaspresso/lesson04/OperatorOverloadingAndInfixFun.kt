package com.guzeluz.kotlincourse.lessons.kaspresso.lesson04

/*
Перегрузка операторов — это возможность задать своё поведение привычных операторов (+, -, *, / и т.д.) для собственных классов.
По сути, мы учим Kotlin: что значит “плюс” для моего объекта.
 */

/*
у нас есть набор химических элементов:
Carbon — углерод — 6 протонов
Boron — бор — 5 протонов
Beryllium — бериллий — 4 протона
Lithium — литий — 3 протона
Magnesium — магний — 12 протонов
 */

interface Nuclear

class Carbon : Nuclear
class Boron : Nuclear
class Lithium : Nuclear
class Magnesium : Nuclear
class Proton

// Выбиваем протон
fun Nuclear.knockOutProton(proton: Proton): Nuclear {
    return when (this) {
        is Carbon -> Boron()
        else -> throw IllegalStateException("Операция не осуществима")
    }
}

operator fun Nuclear.minus(proton: Proton): Nuclear {
    return when (this) {
        is Carbon -> Boron()
        else -> throw IllegalStateException("Операция не осуществима")
    }
}

// оператор деления
operator fun Nuclear.div(parts: Int): Nuclear {
    require(this is Carbon) { "Операция доступна только для углерода" }
    require(parts == 2) { "Доступно деление пополам" }
    return Lithium()
}

// оператор умножения
operator fun Nuclear.times(multiplier: Int): Nuclear {
    require(this is Carbon) { "Операция доступна только для углерода" }
    require(multiplier == 2) { "Доступно объединение двух ядер" }
    return Magnesium()
}


//Инфиксные функции
/*
Инфиксная функция - это функция, которую можно вызывать между объектами, как оператор, без точки и скобок.

В Kotlin это обычная функция, помеченная ключевым словом infix, с одним параметром,
которая объявляется в классе или как расширение класса.
 */

infix fun String.и(other: String): Pair<String, String> {
    return this to other
}

infix fun Pair<String, String>.обсуждали(name: String): String {
    return "Два сплетника, $second и $first, перемыли все кости своих знакомых и теперь знают всё про $name"
}

fun main() {
    val proton = Proton()
    val carbon = Carbon()
    val boron = carbon.knockOutProton(proton)
    println(boron.javaClass.simpleName)

    val boron2 = carbon - proton
    println(boron2.javaClass.simpleName)

    val lithium = carbon / 2
    println(lithium.javaClass.simpleName)

    val magnesium = carbon * 2
    println(magnesium.javaClass.simpleName)

    println("Андрей" и "Светлана" обсуждали "Валентину")

    val pair = "Андрей".и("Светлана")
    val result = pair.обсуждали("Валентину")
    println(result)

// или без переменных
    println("Андрей".и("Светлана").обсуждали("Валентину"))

//    Вот ещё примеры инфиксных функций:
    val map = mapOf(1 to "2")
    val untilRange = 0 until 10
    val downToRange = 10 downTo 0
    val rangeWithStep = 0..10 step 2
    val logicAnd = true and false
    val logicOr = false or true
    val logicXor = true xor false
}
