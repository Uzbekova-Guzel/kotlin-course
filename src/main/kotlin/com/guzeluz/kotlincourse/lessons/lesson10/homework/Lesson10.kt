package com.guzeluz.kotlincourse.lessons.lesson10.homework

fun main() {

//    Задачи на работу со словарём
//    1. Создайте пустой неизменяемый словарь,
//    где ключи и значения - целые числа.
    val a1 = mapOf<Int, Int>()
//    2. Создайте словарь, инициализированный несколькими парами
//    "ключ-значение",
//    где ключи - float, а значения - double.
    val a2 = mapOf<Float, Double>(0.5f to 1.9, 43.5f to 56.3, 64.6f to 6.4)

//    3. Создайте изменяемый словарь,
//    где ключи - целые числа, а значения - строки.
    val a3 = mutableMapOf<Int, String>(0 to "zero", 1 to "one")

//    4. Имея изменяемый словарь,
//    добавьте в него новые пары "ключ-значение".
    val a4 = mutableMapOf<String, Int>("LADA" to 1, "Mercedes" to 2)
    a4["BMV"] = 3

//    5. Используя словарь из предыдущего задания, извлеките значение,
//    используя ключ.
//    Попробуй получить значение с ключом, которого в словаре нет.
    println(a4["BMV"])
    println(a4["Cherry"])

//    6. Удалите определенный элемент из изменяемого словаря по его ключу.
    a4.remove("LADA")

//    7. Создайте словарь (ключи Double, значения Int) и
//    выведи в цикле результат деления ключа на значение.
//    Не забудь обработать деление на 0
//    (в этом случае выведи слово “бесконечность”)
    val a5 = mapOf<Double, Int>(0.5 to 1, 43.4 to 0, 64.6 to 4)
    for ((number1, number2) in a5) {
        val result = if (number2 != 0) number1 / number2 else "бесконечность"
        println(result)
    }

//    8. Измените значение для существующего ключа в изменяемом словаре.
    a4["Mercedes"] = 10

//    9. Создайте два словаря и объедините их
//    в третьем изменяемом словаре через циклы.
    val a6 = mapOf<String, Int>("Potato" to 5, "Eggs" to 10, "Orange" to 3)
    val a7 = mapOf<String, Int>("Potato" to 2, "Onions" to 2)
    val a8 = mutableMapOf<String, Int>()
    for ((vegetable, count) in a6) {
        a8[vegetable] = count
    }
    for ((vegetable, count) in a7) {
        a8[vegetable] = count
    }
    println(a8)

//    10. Создайте словарь, где ключами являются строки,
//    а значениями - списки целых чисел.
//    Добавьте несколько элементов в этот словарь.
    val a9 = mutableMapOf<String, Int>("Misha" to 5, "Anna" to 10, "Sasha" to 9)
    a9["Alex"] = 5
    a9["Sofi"] = 10
    a9["Misha"] = 10

//    11. Создай словарь, в котором ключи - это целые числа,
//    а значения - изменяемые множества строк.
//    Добавь данные в словарь.
//    Получи значение по ключу (это должно быть множество строк) и
//    добавь в это множество ещё строку. Распечатай полученное множество.
    val a10 = mutableMapOf<Int, MutableList<String>>(1 to mutableListOf("Misha", "Masha"))
    println(a10[1])
    a10[1]?.add("Maria")
    println(a10[1])

//    12. Создай словарь, где ключами будут пары чисел.
//    Через перебор найди значение у которого
//    пара будет содержать цифру 5 в качестве первого или второго значения.
    val a11 = mapOf(
        Pair(2, 4) to 2,
        Pair(5, 5) to 4,
        Pair(5, 4) to 10,
        Pair(56, 9) to 45,
        Pair(99, 3) to 1967,
        Pair(5, 689) to 53,
        Pair(24, 87) to 236,
    )
    for ((pair, value) in a11) {
        if (pair.first == 5 || pair.second == 5) println("pair $pair: value $value")
    }

//    Задачи на подбор оптимального типа для словаря
//    1. Словарь библиотека:
//    Ключи - автор книги,
//    значения - список книг.
    val library = mutableMapOf<String, MutableList<String>>()

//    2. Справочник растений:
//    Ключи - типы растений (например, "Цветы", "Деревья"),
//    значения - списки названий растений.
    val plants = mapOf<String, MutableList<String>>()

//    3. Четвертьфинала:
//    Ключи - названия спортивных команд,
//    значения - списки игроков каждой команды.
    val teams = mapOf<String, MutableList<String>>()

//    4. Курс лечения:
//    Ключи - даты,
//    значения - список препаратов принимаемых в дату.
    val courseOfTreatment = mapOf<String, List<String>>()

//    5. Словарь путешественника:
//    Ключи - страны,
//    значения - словари из городов со списком интересных мест.
    val travelPlans = mutableMapOf<String, MutableMap<String, MutableList<String>>>()
}