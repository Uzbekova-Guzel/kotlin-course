package com.guzeluz.kotlincourse.lessons.lesson19

//Вместо того, чтобы делать отдельный класс для хранения каждого типа данных, мы можем сделать универсальный класс.

// Без дженериков:
//class BoxAny(val item: Any)
//
//fun main() {
//    val appleBoxAny = BoxAny("Apple")
//    val intBoxAny = BoxAny(42)
//
//    val appleBoxAnyItem: Any = appleBoxAny.item // Any вместо строки
//    val intBoxAnyItem: Any = intBoxAny.item // Any вместо числа
//}

//С дженериками:
//class Box<R>(val item: R)
//
//fun main() {
//    val appleBox = Box("Apple")
//    val intBox = Box(42)
//
//    val appleBoxItem: String = appleBox.item
//    val intBoxItem: Int = intBox.item
//}

/*
Когда вы пишете class Box<T>, T — это параметр типа,
обычно обозначается одной буквой, но можно использовать и слово (принято использовать только заглавные буквы в словах).
На этапе компиляции Kotlin заменяет T на конкретный тип данных, который вы передали.
Это позволяет одной и той же структуре работать с разными данными, избегая необходимости дублирования кода.
 */


//Дженерик в функциях:
//fun <S> secondOrNull(list: List<S>): S? {
//    return list.getOrNull(1)
//}
//
//fun main() {
//    val secondElementLength: Int? = secondOrNull(listOf("a", "b", "c"))?.length
//}


//Ограничения для дженериков
// Иногда нужно, чтобы дженерик работал только с определенным типом или его подтипами.
fun <T : Number> sum(a: T, b: T): Double {
    return a.toDouble() + b.toDouble()
}

fun main() {
    println(sum(5, 10))        // 15.0
    println(sum(3, 2.5))     // 6.0
}

//Использование нескольких дженериков
class GenericIterator<T : Number, R : Iterable<T>>(
    private val argument: T,
    private val elements: R
) {

    fun printElements() {
        for (e in elements) {
            println(
                e.toString()
                    .repeat(argument.toInt())
            )
        }
    }
}

