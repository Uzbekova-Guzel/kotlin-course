package com.guzeluz.kotlincourse.lessons.lesson20

//До
fun removeSpaces(str: String): String {
    return str.replace(" ", "_")
}
val result = removeSpaces("String with spaces")

//С расширением
//Расширение String класса
fun String?.removeSpaces(): String? {
    return this?.replace(" ", "")
}

val result1 = "Hello, World!".removeSpaces() // "Hello,World!"


//Расширение List
fun <T> List<T?>.isElementsNullOrEmpty(): Boolean {
    return this.all { it == null } || this.isEmpty()
}
val list: List<Int?> = listOf(1, null)
val isEmpty = list.isNullOrEmpty() // true