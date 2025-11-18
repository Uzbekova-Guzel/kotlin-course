package com.guzeluz.kotlincourse.lessons.extensions

fun <T> List<T?>.isElementsNullOrEmpty(): Boolean {
    return all { it == null } || isEmpty()
}
