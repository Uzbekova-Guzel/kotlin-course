package com.guzeluz.kotlincourse.lessons.lesson20

import com.guzeluz.kotlincourse.lessons.extensions.isElementsNullOrEmpty
import com.guzeluz.kotlincourse.lessons.extensions.removeSpaces

//До
fun removeSpaces(str: String): String {
    return str.replace(" ", "")
}
val result = removeSpaces("String with spaces")

//С расширением
//Расширение String класса
val result1 = "Hello, World!".removeSpaces() // "Hello,World!"

//Расширение List
val list: List<Int?> = listOf(1, null)
val isEmpty = list.isElementsNullOrEmpty() // true