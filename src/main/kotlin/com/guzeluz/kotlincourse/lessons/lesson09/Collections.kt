package com.guzeluz.kotlincourse.lessons.lesson09

private const val i = 5

fun main() {
//    Массивы (Arrays) - упорядоченные коллекции фиксированного размера, содержащие элементы одного типа.
    val numbers = arrayOf(1, 2, 3, 4, 5)
    numbers[0] = 10

    val doubles = doubleArrayOf(1.1, 2.2, 3.3)

    val emptyArray = Array(5) { "" }
    val emptyNullArray = Array<String?>(5) { null }
    val emptyNullableArray = arrayOfNulls<Int>(5)

//    Списки в Kotlin более универсальны, они могут быть изменяемыми (MutableList) и неизменяемыми (List).
    val readOnlyList: List<String> = listOf("a", "b", "c")
    val mutableList: MutableList<String> = mutableListOf("a", "b", "c")

    mutableList.add("d")
    mutableList.add(1, "c")
    mutableList.removeAt(0)
    mutableList[0] = "e"

//    Множества (Set) в Kotlin - это коллекции, которые хранят уникальные элементы.

    val numbersSet: Set<Int> = setOf(1, 2, 3, 4, 5)

    val mutableNumbersSet: MutableSet<Int> = mutableSetOf(1, 2, 3, 4, 5)

    val emptySet: Set<Int> = emptySet()
    val emptyMutableSet: MutableSet<Int> = mutableSetOf()

    mutableNumbersSet.add(6)
    mutableNumbersSet.remove(1)

//    Перебор данных в списках

    val set = setOf("K", "o", "t", "l", "i", "n")
    for (letter in set) {
        println("| $letter |")
    }
    val list = listOf(32, 53, 1, -76)
    for (index in list.indices) {
        if (index == list.lastIndex) {
            println(list[index] + list[0])
        } else {
            println(list[index] + list[index + 1])
        }
    }
    var index = list.lastIndex
    while (index >= 0) {
        println("`${list[index--]}`")
    }

//Практика
    val a1: Array<Int> = Array(10) { 0 }
    for (i in a1.indices) {
        a1[i] = (i + 1) * 10
    }

    val a2: Array<Int> = Array(10) { 0 }

    for (i in a2.indices) {
        a2[i] = a1[i]
    }

    val a3: List<Int> = listOf(1, 2, 3)

    val a4 = arrayOf("smth", "smth2")

    val a5 = mutableListOf<Float>()

    a5.add(5.56f)
    a5.add(0, 7.55f)

    for (element in a5) {
        println(element)
    }

    val a6 = listOf("one", "two", "three")

    val a7: Set<Int> = setOf()

    val a8 = mutableSetOf("one", "two", "three")
    a8.add("four")
    a8.remove("two")

    val a9 = setOf(2, 4, 6, 46)
    val a10 = setOf(5, 46, 6, 2)
    val a11 = mutableSetOf<Int>()

    for (element in a9) {
        a11.add(element)
    }

    for (element in a10) {
        a11.add(element)
    }

    val a12 = mutableSetOf<Int>()

    for (element in a9) {
        for (el in a10) {
            if (element == el) a12.add(element)
        }
    }


}

fun example(list: List<String>) {
    val str = "smth"
    for (element in list) {
        if (element == str) {
            println("true")
            return
        }
        println("false")
    }
}