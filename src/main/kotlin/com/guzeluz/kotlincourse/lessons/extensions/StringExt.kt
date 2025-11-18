package com.guzeluz.kotlincourse.lessons.extensions

//fun String.removeSpaces(): String {
//    return replace(" ", "")
//}

fun String?.removeSpaces(): String? {
    return this?.replace(" ", "")
}
