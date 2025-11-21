package com.guzeluz.kotlincourse.lessons.lesson22

import java.io.File

fun main() {
//    1. NullPointerException (NPE)
//    val arg: Int? = null
//    arg!!

//    2. IndexOutOfBoundsException
//    val list = listOf(1)
//    println(list[3])

//    3. ClassCastException
//    val arg1: Any = "String"
//    val num: Int = arg1 as Int

//    4. NumberFormatException
//    val a = "abc"
//    println(a.toInt())

//    5. IllegalArgumentException
//    addMoney(-100)

//    6. IllegalStateException
//    checkState(-100)

//    7. FileNotFoundException
    val file = File("path/to/non/existing/file.txt")
//    println(file.readText())

//    8. IOException
//    val f = File("fff")
//    f.createNewFile()
//    val i = f.inputStream()
//    i.close()
//    i.read()

//    9. OutOfMemoryError
    val list = mutableListOf<Float>()
//    while (true) {
//        list.add(Math.PI.toFloat())
//    }

//    10. StackOverflowError
//    fun1()

    /* 12. Сделай перехват кода, выбрасывающего исключение и
    в секции обработки выброси своё исключение с текстом из перехваченного.
    Добавь блок finally и проверь как он работает:
        С одним блоком catch
     */
    try {
        val list = listOf(1, 2, 3)
//        println(list[20])
    } catch (e: ArrayIndexOutOfBoundsException) {
        throw MyException(e.message)
    }
}

//    5. IllegalArgumentException
fun addMoney(money: Int) {
    require(money > 0) {
        "Money hdsh"
    }
}

//6. IllegalStateException
fun checkState(money: Int) {
    check(money > 0) {
        "Money hdsh"
    }
}

//    10. StackOverflowError
fun fun1() {
    fun1()
}

//11. Создай своё исключение MyException, в которое можно передать текст.

class MyException(message: String?) : RuntimeException(message)
