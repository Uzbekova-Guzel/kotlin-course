package com.guzeluz.kotlincourse.lessons.lesson21

//Приведение типов
fun main() {

//    Проверка типов с is и !is
    val obj: Any = "Hello, World!"
    if (obj is String) {
        obj.length
        println("Объект является строкой")
    }
    if (obj !is Int) {
        println("Объект не является целым числом")
    }

//    Преобразование типов (умное приведение)
    if (obj is String) {
        // obj автоматически приведён к String
        println(obj.uppercase()) // Метод uppercase() доступен, т.к. obj теперь String
    }

//    Явное преобразование типов с as и as?
    val num: Any = 123
//    val str: String = num as String // Выбросит ClassCastException

    val safeStr: String? = num as? String // safeStr будет равно null

//    val num1: W1 = W3()
//    val num2: W2 = num as W2

//    Работа с нулевыми и не нулевыми типами
    val nullableStr: String? = "Kotlin"
    val nonNullableStr: String = nullableStr as String // Явное приведение типа из нулевого типа на ненулевой

    // Примеры:
    val mixedList: List<Any> = listOf("Kotlin", 42, 3.14, "Java", true)
    for (item in mixedList) {
        when (item) {
            is String -> println("$item - строка длиной ${item.length}")
            is Int -> println("$item - целое число")
            is Double -> println("$item - вещественное число")
            else -> println("Неизвестный тип")
        }
    }

//
//    val car = Car()
//    checkCapabilities(car)
//
//    val flyingCar = FlyingCar()
//    checkCapabilities(flyingCar)
}

//interface W1 {}
//interface W2
//class W3 : W1, W2
//
//interface Drivable {
//    fun drive()
//}
//
//interface Flyable {
//    fun fly()
//}
//
//open class Car : Drivable {
//
//    override fun drive() {
//        println("Едет как автомобиль")
//    }
//}
//
//class FlyingCar : Car(), Flyable {
//
//    override fun fly() {
//        println("Летит как самолёт")
//    }
//}
//
//fun checkCapabilitiesWithSmartCast(drivable: Drivable) {
//    drivable.drive()
//    if (drivable is Flyable) {
//        drivable.fly()
//    } else {
//        println("Этот объект не может летать.")
//    }
//}
//
//fun checkCapabilities(drivable: Drivable) {
//    drivable.drive()
//    (drivable as? Flyable)?.fly() ?: println("Этот объект не может летать.")
//}
