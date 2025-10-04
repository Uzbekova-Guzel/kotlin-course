package com.guzeluz.kotlincourse.lessons.lesson08.homework

fun main() {
    toUpperCase("Котлин ЛУЧШИЙ язык программированиЯ")
    encrypt("Two")
    decrypt("оКлтни")
    getMultiplicationTable(100, 100)
}

//Задания повышенной сложности
/*
7. Все слова с большой буквы
Напишите метод, который преобразует строку из нескольких слов в строку,
где каждое слово начинается с заглавной буквы а все остальные - строчные.
Используй перебор, анализ символов и замену букв на заглавную
с помощью метода uppercase() для конкретной буквы.
 */

fun toUpperCase(arg: String) {
    val argList = arg.split(" ")
    val argListUpperCase = mutableListOf<String>()
    for (word in argList) {
        val first = word[0].uppercase()
        val rest = word.substring(1)
            .lowercase()
        argListUpperCase += "$first$rest"
    }
    println(argListUpperCase.joinToString(" "))
}

/*
8. Игра в разведчика
Напишите шифратор/дешифратор для строки.
Шифровка производится путём замены двух соседних букв между собой:
Kotlin шифруется в oKltni.
Дешифровка выполняется аналогично.
Если длина строки - нечётная, в конец добавляется символ пробела до начала шифрования.
Таким образом все шифрованные сообщения будут с чётной длинной.
Должно получиться два публичных метода: encrypt() и decrypt()
которые принимают строку и печатают результат в консоль.
*/
private fun swapPairs(arg: String): String {
    var str = arg
    var result = ""
    if (str.length % 2 != 0) str += " "
    for (i in str.indices step 2) {
        result += "${str[i + 1]}${str[i]}"
    }
    return result
}

fun encrypt(arg: String) {
    println(swapPairs(arg))
}

fun decrypt(arg: String) {
    println(swapPairs(arg).trimEnd())
}

/*
9. Таблица умножения
Напишите функцию, которая принимает два числа и выводит таблицу умножения,
у которой в заголовках столбцов и строк находятся перемножаемые числа,
а в перекрестии заголовка и столбца - результат перемножения.
Важно: каждый столбец должен быть выровнен по правому краю с помощью шаблона с форматированием строк.
Размер форматирования каждой строки нужно вычислять динамически для каждого столбца.
 */
fun getMultiplicationTable(row: Int, column: Int) {
    //Сохраняем ширину столбцов
    val columnWidth = mutableListOf<Int>()
    columnWidth.add(row.toString().length)
    for (i in 1..column) {
        columnWidth.add((i * row).toString().length + 1)
    }

    //Печатаем первую строку
    print(" ".repeat(columnWidth[0]))
    for (j in 1..column) {
        print(String.format("%${columnWidth[j]}d", j))
    }
    println()

    for (i in 1..row) {
        print(String.format("%${columnWidth[0]}d", i))
        for (j in 1..column) {
            print(String.format("%${columnWidth[j]}d", i * j))
        }
        println()
    }
}
