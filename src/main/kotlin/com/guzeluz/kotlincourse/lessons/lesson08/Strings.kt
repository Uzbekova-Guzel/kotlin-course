package com.guzeluz.kotlincourse.lessons.lesson08

fun main() {
    val simpleString = "Это простая строка"

//  Конкатенация строк
    val firstName = "Иван"
    val lastName = "Иванов"
    val fullName = firstName + " " + lastName  // "Иван Иванов"

//    Шаблоны строк
    val age1 = 30
    val greeting = "Привет! Меня зовут $firstName, и мне $age1 лет."

//    Манипуляции со строками
    val originalString = "Kotlin is fun"
    val subString = originalString.substring(7)  // "is fun"
    val string = "Sweet summer child"
    val subString1 = string.substring(6) // "summer child"
    val subString2 = originalString.substring(3, 6) // "lin"
    val string2 = "Sweet summer child"
    val subString3 = string.substring(6, 12) // "summer"
    val replacedString = originalString.replace("fun", "awesome")  // "Kotlin is awesome"
    val words = originalString.split(" ")  // ["Kotlin", "is", "fun"]
    val lists = words.joinToString(" ")
    val length = "Hello".length  // 5
    val upper = "hello".uppercase()  // "HELLO"
    val lower = "HELLO".lowercase()  // "hello"
    val trimmed = "  hello  ".trim()  // "hello"

    val starts = "Kotlin".startsWith("Kot")  // true
    val starts2 = " kotlin".trim().startsWith("Kot", true)  // true
    val ends = "Kotlin".endsWith("lin")  // true
    val contains = "Hello".contains("ell")  // true
    val empty = "".isNullOrEmpty()  // true
    val blank = "  ".isNullOrBlank()  // true
    val repeat = "ab".repeat(3)  // "ababab"
    val letter = originalString.get(5) // 'n'
    val letter1 = originalString[5] // 'n'
    val indexOfChar = "Kotlin".indexOf('t') // 2
    val indexOfChar1 = "Kotlin".indexOf("li") // 3
    val indexOfChar2 = "Kotlin".indexOf("ft") // -1
    val indexOfWord = "Kotlin is the best language".indexOf("best")
    val backReverse = "niltoK".reversed()

//    Многострочные строки
    val multiLineString = """
       Первая строка
       Вторая строка
       Третья строка
    """.trimIndent()

//    Форматирование строк
    val name = "Алексей"
    val city = "Москва"
    val age = 32
    val friendsCount = 1052
    val rating = 4.948
    val balance = 2534.75856
    val text = """
  Имя: %s
  Город: %s
  Возраст: %d
  Количество друзей: %,d
  Рейтинг пользователя: %.1f
  Баланс счета: $%,.2f
""".trimIndent()
    println(text.format(name, city, age, friendsCount, rating, balance))
    /*
    Результат:
    Имя: Алексей
    Город: Москва
    Возраст: 32
    Количество друзей: 1 052
    Рейтинг пользователя: 5,0
    Баланс счета: $2 534,76
    */

}

//    Обращение к свойствам объекта
class Person(val name: String, val age: Int)

val person = Person("Алексей", 25)
val introduction = "Меня зовут ${person.name}, и мне ${person.age} лет."

// Использование методов в шаблонных строках
//fun getDetails(): String {
//    return "очень интересные детали"
//}

//val details = "Здесь находятся ${getDetails()}"

//Сложные выражения

val x = 10
val y = 20
val resultString = "Результат сложения x и y равен ${x + y}"

fun example(arg: String) {
    val result = when {
        arg.startsWith("ошибка") -> arg.replace("ошибка", "небольшое недоразумение")
        arg.endsWith("важно") -> "$arg…но не критично"
        arg.contains("проблема") -> arg.replace("проблема", "неожиданность")
        arg.indexOf("срочно") in 0..10 -> arg.replace("срочно", "когда-нибудь")
        arg.isBlank() -> "Кажется, кто-то забыл что-то сказать"
        else -> arg
    }
    println(result)
}

