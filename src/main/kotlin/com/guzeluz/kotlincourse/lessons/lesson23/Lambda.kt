package com.guzeluz.kotlincourse.lessons.lesson23

// Обычное объявление функции
fun increment(a: Int): Int {
    return a + 1
}

fun main() {

//    Трансформация в анонимную функцию
    // Анонимная функция, присвоенная переменной
    val increment1 = fun(a: Int): Int {
        return a + 1
    }

    println(increment(2))
    println(increment1(2))

//    Трансформация в лямбда выражение
// Лямбда выражение с явно указанным типом
    val increment2: (Int) -> Int = { a ->
        a + 1
    }

//    Упрощение лямбда выражения
// Лямбда выражение с использованием 'it' для однопараметрической лямбды
    val increment3: (Int) -> Int = {
        it + 1
    }

//    Ещё большее упрощение
// Лямбда выражение без явного указания типа
    val increment4 = { a: Int ->
        a + 1
    }
}
