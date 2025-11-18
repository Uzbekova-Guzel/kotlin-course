package com.guzeluz.kotlincourse.lessons.lesson21

import kotlin.math.absoluteValue

fun main() {
    val arg: Any = "Smth"
//    println((arg as String).length)
//    println(arg as Int)
    if (arg is String) {
        println(arg)
    } else {
        println("This is not string!")
    }

    println(arg as? String ?: "This is not string!")

    val arg1: Any = listOf("first")
//    println(arg1 as List<String>)
//    println((arg1 as List<Int>)[0].absoluteValue)

//    if (arg1 is List<*>) {
//        println(arg1)
//    } else {
//        println("Smth")
//    }


//    if ((arg1 as List<*>).isNotEmpty() && arg1[0] is String) {
//        println(arg1[0])
//    }

    println((arg1 as? List<*>)?.getOrNull(0) as? String ?: "It is not string")
}

//fun tryMultiple(arg: Any) : Int? {
//    if (arg is Int) {
//        return arg * 2
//    } else if (arg is String) {
//        return arg.toInt() * 2
//    } else {
//        return null
//    }
//}

fun tryMultiple(arg: Any): Int? {
    return (arg as? Int)?.times(2) ?: (arg as? String)?.toIntOrNull()?.times(2)
}
