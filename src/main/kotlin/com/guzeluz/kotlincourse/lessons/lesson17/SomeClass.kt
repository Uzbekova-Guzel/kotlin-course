package com.guzeluz.kotlincourse.lessons.lesson17

class SomeClass private constructor(val arg1: Int, val arg2: Int) {

    companion object {

        fun init(arg1: Int): SomeClass {
            return SomeClass(arg1, arg1 + 1)
        }
    }

    private val data = mutableListOf<AnotherClass>()

    fun add(arg: Int) {
        data.add(AnotherClass(arg + arg2))
    }

    fun get(): List<Int> {
        return data.map { it.arg }
    }
}

private data class AnotherClass(val arg: Int)

fun main() {
    val someClass: SomeClass = SomeClass.init(1)
//    val t: MutableList<AnotherClass> = someClass.data
}