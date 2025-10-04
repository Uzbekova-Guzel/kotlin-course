package com.guzeluz.kotlincourse.lessons.lesson08.homework

fun main() {
    changeString("Этот код работает без проблем")
    getDateAndTime("Пользователь вошел в систему -> 2021-12-01 09:48:23")
    println(disguiseCreditCard("4539 1488 0343 6467"))
    println(formatEmail("username@example.com"))
    extractFileName("D:/good.themes/dracula.theme")
    getAbbreviation("Котлин лучший язык программирования")
}

//1. Преобразование строк
fun changeString(arg: String) {
    val result = when {
        arg.contains("невозможно") -> arg.replace("невозможно", "совершенно точно возможно, просто требует времени")
        arg.startsWith("Я не уверен") -> "$arg, но моя интуиция говорит об обратном"
        arg.contains("катастрофа") -> arg.replace("катастрофа", "интересное событие")
        arg.endsWith("без проблем") -> arg.replace("без проблем", "с парой интересных вызовов на пути")
        arg.split(" ").size == 1 -> "Иногда, ${arg.lowercase()}, но не всегда"
        else -> arg
    }
    println(result)
}

//2. Извлечение даты из строки лога
fun getDateAndTime(arg: String) {
    val result = arg.split(" ")
    println("Date: ${result[result.size - 2]}\nTime: ${result[result.size - 1]}")
}

//3. Маскирование личных данных
fun disguiseCreditCard(cardNumber: String) = "**** **** **** ${cardNumber.substring(cardNumber.length - 4)}"

//4. Форматирование адреса электронной почты
fun formatEmail(email: String) = email.replace("@", " [at] ")
    .replace(".", " [dot] ")

//5. Извлечение имени файла из пути.
fun extractFileName(path: String) {
    val result = path.split("/")
    println(result[result.size - 1])
}

//6. Создание аббревиатуры из фразы.
fun getAbbreviation(phrase: String) {
    val phraseList = phrase.split(" ")
    var abbr = ""
    for (i in phraseList) {
        abbr += i[0]
    }
    println(abbr.uppercase())
}

