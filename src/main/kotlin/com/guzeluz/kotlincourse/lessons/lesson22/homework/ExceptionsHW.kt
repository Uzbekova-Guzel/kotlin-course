package com.guzeluz.kotlincourse.lessons.lesson22.homework

import com.guzeluz.kotlincourse.lessons.lesson20.list

fun main() {
    // 1-8 Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:

//1 NullPointerException
//    val arg: String? = null
//    arg!!

//2 IndexOutOfBoundsException
//    val arg2 = listOf(1, 2, 3)
//    println(list[4])

//3 ClassCastException
//    val arg2: Any = 123
//    val arg2Str: String = arg2 as String

//4 IllegalArgumentException
//    addMoney(-100)

//5 NumberFormatException
//    val arg3 = "2A"
//    println(arg3.toInt())

//6 IllegalStateException
//    checkState(-100)


//7 OutOfMemoryError
//    val arg4 = mutableListOf<Float>()
//    while (true) {
//        arg4.add(Math.PI.toFloat())
//    }

//8 StackOverflowError
//    fun1()
}

//4 IllegalArgumentException
fun addMoney(money: Int) {
    require(money > 0) {
        "Money hdsh"
    }
}

//6 IllegalStateException
fun checkState(money: Int) {
    check(money > 0) {
        "Money hdsh"
    }
}

//8 StackOverflowError
fun fun1() {
    fun1()
}


/*Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и
создай для каждого типа ошибки свой catch блок
 */

/*Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и
в блоке try/catch выполни набор действий с этим аргументом,
которые могут потенциально вызвать одно из исключений в этом же порядке:
NullPointerException
IndexOutOfBoundsException
ClassCastException
IllegalArgumentException
NumberFormatException
IllegalStateException
В блоке catch перехватывай исключение с общим типом Throwable,
а внутри через when определи тип исключения и выведи сообщение
с названием исключения.
Сразу после when выброси перехваченное исключение через throw,
чтобы прекратить работу программы.
Если аргумент функции не вызвал исключение, то выведи текст,
сообщающий, что переданный аргумент фантастически хорош!
 */

/*Задание 11. Создай свой тип исключения в отдельном файле,
наследуемый от AssertionError и принимающий текст.
Выброси это исключение в main
 */

/*Задание 12. Создай свой тип исключения в отдельном файле,
наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип
в качестве аргумента. Напиши код, который спровоцирует выброс
IndexOutOfBoundsException, перехвати его с помощью try-catch и
в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
 */
