package com.guzeluz.kotlincourse.lessons.lesson07

fun main() {
//    Цикл for
//    Прямое Задание Диапазона:
    for (i in 1..10) {
        println(i)
    }

//    Обратный Диапазон:
    for (i in 10 downTo 1) {
        println(i)
    }

//    С Шагом (step):
    for (i in 1..10 step 2) {
        println(i)
    }

//    Использование До (until):
    for (i in 1 until 10) { // не включая 10
        println(i)
    }

//    Цикл while
    var counter1 = 0
    while (counter1++ < 10) {
        println(counter1)
    }

//    Цикл do while
    var counter2 = 0
    do {
        println(counter2)
    } while (counter2++ < 10)

//    Прерывание и Пропуск Итерации

//    break: Прерывает цикл.
    for (i in 1..10) {
        if (i == 3) break
        println(i)
    }

//    continue: Пропускает текущую итерацию и переходит к следующей.
    for (i in 1..10) {
        if (i == 3) continue
        println(i)
    }

    for (i in 10 downTo 1 step 3) {
        if (i % 2 == 0) println(i * i)
    }

    val length = 34
    for (i in 0 until length) {
        println(i)
    }

    var counter3 = 0
    var sum = 0
    while (counter3 <= 10) {
        sum += counter3
        counter3++
    }

    var counter4 = 0
    var sum2 = 0
    do {
        counter4++
        sum2 += counter4
    } while (sum2 + counter4 <= 50)
    println(sum2)

    var counter5 = 1
    while (true) {
        println(counter5)
        if (counter5++ % 7 == 0) break
    }

    for (i in 1..10) {
        if (i == 3 || i == 7) continue
        println(i)
    }

    var counter6 = 0
    for (i in 20 downTo 1) {
        counter6++
        if (counter6 == 4) {
            counter6 = 0
            continue
        }
        println(i)
    }
}
