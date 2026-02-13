package com.guzeluz.kotlincourse.lessons.kaspresso.lesson05

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/*
DSL
DSL (Domain-Specific Language или Проблемно-ориентированный язык) - это специализированный язык,
разработанный для решения конкретного набора задач в определённой предметной области.
 */

//Оператор invoke
operator fun String.invoke(arg: String) {
    println("$this: $arg")
}

//Использование лямбды с ресивером
fun String.halve(): String {
    return substring(0, length / 2)
}

val halve: String.() -> String = {
    substring(0, length / 2)
}

//Объединяем invoke и лямбду с ресивером
object Commands {
    fun execute(command: String) {
        Thread.sleep(100)
        /* some logic */
    }
}

operator fun String.invoke(fnc: String.() -> String): String {
    return fnc()
}

operator fun String.invoke() {
    val time = LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS"))
    println("$time - $this")
    Commands.execute(this)
}

object Server {

    operator fun invoke(fnc: Server.() -> Unit) {
        fnc()
    }

    fun start() {
        "start server"()
    }

    fun loadOs() {
        "load operation system"()
    }

    fun login() {
        "login by default user"()
    }
}



fun main() {
    "Kotlin".invoke("forever")
    "Kotlin"("forever")

    Server.apply {
        start()
        loadOs()
        login()
    }

    Server {
        start()
        loadOs()
        login()
    }
}