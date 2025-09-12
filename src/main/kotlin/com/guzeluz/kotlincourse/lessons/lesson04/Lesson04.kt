package com.guzeluz.kotlincourse.lessons.lesson04

import kotlin.Array
import kotlin.Int

//Числовые типы
val myInt: Int = 5
val myFloat: Float = 0.58F
val myLong: Long = 1_234_567_890L
val myShort: Short = 32000
val myByte: Byte = 120
val myDouble: Double = 5.99

val myUInt: UInt = 5U //только положительные значения

//Логический тип
val isKotlinFun: Boolean = true

//Символьный тип
val letter: Char = 'A'

//Строковый тип
val text: String = "Hello, Kotlin!"

//Коллекции
val numbers: Array<Int> = arrayOf(1, 2, 3)
val strings: List<String> = listOf("one", "two", "one")
val doubles: Set<Double> = setOf(23.3, 56.8)

//Словари
val keysToValues: Map<Int, String> = mapOf(
    1 to "Значение 1",
    2 to "Значение 2",
)

//Any: может содержать значение любого типа. equals(), hashCode() и toString()
val numbers1: Array<Any> = arrayOf(1, 2, "string")

var something: Any = "24"
fun change() {
    something = 24
    something = true
    something = ArrayList<String>()
}

//Unit: Он используется для обозначения ситуаций, когда функция не возвращает значимое значение.
val unit: Unit = Unit

//Nothing: Не имеет значений и используется для обозначения функций, которые никогда нормально не завершаются
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

//Практика

val val1: Byte = 100
val val2: Long = 156L
val val3: Float = 12.34f
val val4: Double = 123.456
val val5: String = "Hello, World!"
val val6: Boolean = true
val val7: Char = 'a'
val val8: Int = 0
val val9: Long = 9999999999L
val val10: Float = 25.0f
val val11: Double = -123.4
val val12: List<Int> = listOf(2, 3, 4)
val val13: Char = '?'
val val14: String = "Kotlin"
val val15: Set<Double> = setOf(3.14, 45.0)
val val16: Boolean = false
val val17: String = "D"
val val18: Long = 2147483648L
val val19: Array<String> = arrayOf("Hello", "world")
val val20: String = "true"
val val21: Map<Int, String> = mapOf(12 to "Kotlin")
val val22: Float = 0.1f
val val23: Char = '!'
val val24: Map<String, Any> = mapOf("a" to 'a', "b" to true)
val val25: Map<String, Any?> = mapOf("a" to 'a', "b" to true, "c" to null)

//Хранить количество раз, сколько сосед включал перфоратор в воскресенье утром на протяжении года.
val val26: Int = 50
//Хранить уровень чечевичного супа с фрикадельками в кастрюле в долях сантиметра.
val val27: Float = 2.07f
//Хранить букву года, которую выбрали на ежегодной конференции важных букв.
val val28: Char = 'G'
//Хранить энергию столкновения мухи с лбом академика при вылете из адронного коллайдера.
val val29: Double = 1.35435478
//Хранить число прыжков лягушки через лужи во время одной прогулки.
val val30: Short = 345
//Хранить словарь «имя разработчика → причина, почему задача до сих пор не сделана».
val val31: Map <String, String> = mapOf("" to "")
//Хранить признак, включен ли временный костыль трёхлетней давности на продакшене.
val val32: Boolean = false
//Хранить количество тапков, которые кот утащил за диван сегодня, при том что тапки есть только у меня и жены.
val val33: Byte = 6
//Хранить переменную, которая хранит общее количество крошек на диване после вечеринки студентов.
val val34: Long = 1_343_343_654L
//Хранить список зачислений на карту, чтобы всегда можно было посмотреть и поплакать.
val val35: Array<Double> = arrayOf(3.46, 3.234)
//Хранить список отговорок «почему тесты упали», чтобы не придумывать заново.
val val36: List<String> = listOf("because of", "")
//Хранить строку «будет сделано завтра» для автоматических ответов.
val val37: String = "будет сделано завтра"