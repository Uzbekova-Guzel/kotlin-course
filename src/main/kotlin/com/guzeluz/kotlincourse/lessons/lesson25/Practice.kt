package com.guzeluz.kotlincourse.lessons.lesson25

import com.guzeluz.kotlincourse.lessons.lesson19.sum

/*Задание 1
Создай функцию, возвращающую целое число.
В теле функции создай список чисел,
выведи на печать сумму чисел списка,
верни сумму чисел из функции.
Сделай то же самое без создания переменных
с использованием функции also и apply.*/
fun ex1(): Int {
    val list = listOf(1, 2, 3, 4, 5)
    val sum = list.sum()
    println(sum)
    return sum
}

//also
fun ex11(): Int {
    return listOf(1, 2, 3, 4, 5).sum()
        .also { println(it) }
}

//apply
fun ex111(): Int {
    return listOf(1, 2, 3, 4, 5).sum()
        .apply { println(this) }
}

/*Задание 2
Создай функцию, возвращающую число.
В теле функции создай изменяемый список чисел,
добавь в него ещё число, добавь ещё число, распечатай длину списка,
верни сумму чисел списка из функции.
Напиши то же самое без создания переменных используя функции with и run.*/
fun ex2(): Int {
    val list2 = mutableListOf(1, 2, 3, 4, 5)
    list2.add(6)
    list2.add(7)
    println(list2.size)
    return list2.sum()
}

//with
fun ex22(): Int {
    return with(mutableListOf(1, 2, 3, 4, 5)) {
        add(6)
        add(7)
        println(size)
        sum()
    }
}

//run
fun ex222(): Int {
    return mutableListOf(1, 2, 3, 4, 5).run {
        add(6)
        add(7)
        println(size)
        sum()
    }
}

/*Задание 3
Создай функцию, принимающую nullable список строк и
возвращающую сумму длин слов предварительно выведя его на печать.
Если список является null то вернуть ноль. Реши через if / else.
Реши через let и also.*/
fun ex3(list3: List<String>?): Int {
    if (list3 != null) {
        val size = list3.sumOf { it.length }
        println(size)
        return size
    } else {
        println(0)
        return 0
    }
}

//let/also
fun ex33(list3: List<String>?): Int {
    return (list3?.let { map -> map.sumOf { it.length } } ?: 0)
        .also { println(it) }
}


/*Задание 4
Создай класс UserConfig с полем id в конструкторе и двумя пустыми полями
в теле класса: lang и country.

Создай функцию, которая принимает id и объект типа UserConfig  nullable и
возвращает новый объект UserConfig с переданным id и с заполненными
полями lang и country если переданный в функцию объект UserConfig  не был null.
Реши задачу через if / else и через подходящие scope функции,
которые помогут избежать создания переменных и проверки на null.*/
class UserConfig(val id: String) {
    var lang: String = "DE"
    var country: String = "Germany"
}

fun ex4(id: String, oldUserConfig: UserConfig?): UserConfig {
    val userConfig = UserConfig(id)
    if (oldUserConfig != null) {
        userConfig.lang = oldUserConfig.lang
        userConfig.country = oldUserConfig.country
    }
    return userConfig
}

//apply/let
fun ex44(id: String, oldUserConfig: UserConfig?): UserConfig {
    return UserConfig(id).apply {
        oldUserConfig?.let {
            lang = it.lang
            country = it.country
        }
    }
}
