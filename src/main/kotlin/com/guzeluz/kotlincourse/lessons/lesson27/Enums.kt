package com.guzeluz.kotlincourse.lessons.lesson27

//Простая группа констант
object NumsObject {
    const val ONE = "ONE"
    const val TWO = "TWO"
    const val THREE = "THREE"
}
//Enum вместо констант
enum class Nums {
    ONE,
    TWO,
    THREE,
    ;
}

//Использование в when
fun printNum(num: Nums) {
    when(num) {
        Nums.ONE -> println(1)
        Nums.TWO -> println(2)
        Nums.THREE -> println(3)
    }
}

//Конструкторы:
enum class DayOfWeek(val dayNumber: Int, val isWeekend: Boolean) {
    MONDAY(1, false),
    TUESDAY(2, false),
    WEDNESDAY(3, false),
    THURSDAY(4, false),
    FRIDAY(5, false),
    SATURDAY(6, true),
    SUNDAY(7, true);

    companion object {
        fun getDay(dayNumber: Int): DayOfWeek {
            return entries.firstOrNull { it.dayNumber == dayNumber }
                ?: throw IllegalArgumentException("Нет дня недели с номером $dayNumber")
        }
    }

    fun printDayType() {
        if(isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }
}

/*Ограничения и особенности
Неизменяемость: После создания enum константы неизменяемы.
Вы не можете динамически добавлять или удалять константы во время
выполнения программы.
Экземпляры: Каждая константа перечисления является экземпляром
перечислительного класса, поэтому вы можете использовать их в when
выражениях без необходимости добавления else ветки, так как Kotlin знает
ограниченное количество возможных экземпляров.
*/

enum class CoffeeType(val cost: Double, val coffeeBase: String, val recommendedSugar: Int, val hasMilk: Boolean = false) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0);

    fun description() = "The $coffeeBase ${if (hasMilk) "with" else "without"} milk costs \$$cost and is best with $recommendedSugar spoons of sugar."
}

fun main() {
    NumsObject.ONE
    "ON"

    println(Nums.ONE)
    for (n in Nums.entries) {
        println(n)
    }

    printNum(Nums.ONE)

    DayOfWeek.SATURDAY.printDayType()
    println(DayOfWeek.entries)
    println(DayOfWeek.getDay(3))
}
