package com.guzeluz.kotlincourse.lessons.lesson23

import kotlin.text.contains

//Трансформация функции в лямбда выражение
//1. Создай функцию, которая не принимает аргументов и
// печатает приветственное сообщение. Трансформируй
//    1. в анонимную функцию
//    2. в лямбда выражение с указанием типа
//    3. в краткое лямбда выражение.
fun ex1() {
    println("Hello world!")
}

val ex2 = fun() {
    println("Hello world!")
}

val ex3: () -> Unit = {
    println("Hello world!")
}

val ex4 = {
    println("Hello world!")
}

//2. Создай функцию, которая принимает строку и возвращает его длину.
// Трансформируй
//    1. в анонимную функцию
//    2. в лямбда выражение с указанием типа
//    3. в краткое лямбда выражение.
fun ex5(str: String): Int {
    return str.length
}

val ex6 = fun(str: String): Int {
    return str.length
}

val ex7: (String) -> Int = {
    it.length
}

val ex8 = { str: String ->
    str.length
}

//3. Создай функцию-расширение класса String, которая принимает число и символ и
// возвращает true если строка короче этого числа и содержит переданный символ.
// Трансформируй в анонимную функцию,
// потом в лямбду с типом.
fun String.ex9(number: Int, symbol: Char): Boolean {
    return length < number && contains(symbol)
}

val ex10 = fun String.(number: Int, symbol: Char): Boolean {
    return length < number && contains(symbol)
}

val ex11: String.(Int, Char) -> Boolean = { number, symbol ->
    length < number && contains(symbol)
}

//4. Создай функцию-расширение дженерика, которая принимает дженерик и
// выводит его на печать. Попробуй трансформировать в анонимную функцию.
fun <T> T.ex12(arg: T) {
    println(arg)
}

//Анонимные функции и лямда выражения не бывают с дженериками!!!
// Поэтому код ниже не будет работать:
//val ex13 = fun <T> T.(arg: T) {
//    println(arg)
//}

fun main() {
    ex1()
    ex2()
    ex3()
    ex4()

    println(ex5("World"))
    println(ex6("World"))
    println(ex7("World"))
    println(ex8("World"))

    println("help".ex9(7, 'p'))
    println("help".ex10(3, 'p'))
    println("help".ex11(9, 'a'))
}
