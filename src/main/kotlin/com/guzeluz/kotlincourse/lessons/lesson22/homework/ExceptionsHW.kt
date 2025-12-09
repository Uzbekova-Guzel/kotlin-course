package com.guzeluz.kotlincourse.lessons.lesson22.homework

fun main() {
    /*1-8 Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
    Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и
создай для каждого типа ошибки свой catch блок
 */

//1 NullPointerException
    try {
        val arg: String? = null
        arg!!
    } catch (e: NullPointerException) {
        println(e.message)
    }

//2 IndexOutOfBoundsException
    try {
        val arg2 = listOf(1, 2, 3)
        println(arg2[4])
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
    }

//3 ClassCastException
    try {
        val arg2: Any = 123
        val arg2Str: String = arg2 as String
    } catch (e: ClassCastException) {
        println(e.message)
    }

//4 IllegalArgumentException
    try {
        checkAge(15)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

//5 NumberFormatException
    try {
        val arg3 = "2A"
        println(arg3.toInt())
    } catch (e: NumberFormatException) {
        println(e.message)
    }

//6 IllegalStateException
    try {
        checkPermission(false)
    } catch (e: IllegalStateException) {
        println(e.message)
    }

//7 OutOfMemoryError
//    try {
//        val arg4 = mutableListOf<Float>()
//        while (true) {
//            arg4.add(Math.PI.toFloat())
//        }
//    } catch (e: OutOfMemoryError) {
//        println(e.message)
//    }

//8 StackOverflowError
//    try {
//        fun1()
//    } catch (e: StackOverflowError) {
//        println(e.message)
//    }

//10
    try {
        catchException(null) // здесь будет NullPointerException
    } catch (e: Throwable) {
        println(e.message)
    }

//11
//    throw MyAssertionError("Something is wrong!!!")

//12
    try {
        listOf("")[12]
    } catch (e: IndexOutOfBoundsException) {
        println("It is IndexOutOfBoundsException")
//        throw MyRuntimeException(e)
    }

}

//4 IllegalArgumentException
fun checkAge(age: Int) {
    require(age >= 18) {
        "You are not adult"
    }
}

//6 IllegalStateException
fun checkPermission(access: Boolean) {
    check(access) {
        "You don't have the permission!"
    }
}

//8 StackOverflowError
fun fun1() {
    fun2()
}

fun fun2() {
    fun1()
}

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
сообщающий, что переданный аргумент фантастически хорош! */
fun catchException(arg: Any?) {
    try {
        // NullPointerException
        arg!!

        // ClassCastException
        val list = arg as List<*>

        // IndexOutOfBoundsException
        val element = list[10]

        // IllegalArgumentException
        require(element is String)

        // NumberFormatException
        val number = (element as String).toInt()

        // IllegalStateException
        check(number == 3)

        println("We have a fantastically good argument!")
    } catch (e: Throwable) {
        val result = when (e) {
            is NullPointerException -> "It is NullPointerException"
            is IndexOutOfBoundsException -> "It is IndexOutOfBoundsException"
            is ClassCastException -> "It is ClassCastException"
            is IllegalArgumentException -> "It is IllegalArgumentException"
            is NumberFormatException -> "It is NumberFormatException"
            is IllegalStateException -> "It is IllegalStateException"
            else -> "It is unknown exception"
        }
        println(result)
        throw e
    }
}

/*Задание 11. Создай свой тип исключения в отдельном файле,
наследуемый от AssertionError и принимающий текст.
Выброси это исключение в main */
class MyAssertionError(message: String) : AssertionError(message)

/*Задание 12. Создай свой тип исключения в отдельном файле,
наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип
в качестве аргумента. Напиши код, который спровоцирует выброс
IndexOutOfBoundsException, перехвати его с помощью try-catch и
в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения. */
class MyRuntimeException(message: IndexOutOfBoundsException) : RuntimeException(message)
