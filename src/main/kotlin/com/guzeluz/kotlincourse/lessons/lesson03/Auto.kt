package com.guzeluz.kotlincourse.lessons.lesson03

const val WHEEL_COUNT: Int = 4

class Auto {
    private val vinCode: String = "NGH45G6"
    var carColor: String = "red"
    var mileAge: Int = 0
    lateinit var ownerName: String

    val reportOfUtil: String by lazy {
        "sample text"
    }
}

val test = 1