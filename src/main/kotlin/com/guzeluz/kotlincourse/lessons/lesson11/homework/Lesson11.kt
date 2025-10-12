package com.guzeluz.kotlincourse.lessons.lesson11.homework

//Задачи на сигнатуру метода.
// Напишите сигнатуру метода в которую входит модификатор доступа,
// название функции, список аргументов с типами и возвращаемое значение.
// В теле метода можешь сделать возврат объекта нужного типа
// если это требуется для устранения ошибок.

//1 Не принимает аргументов и не возвращает значения.

fun getInfo() {
    println("There some info for you")
}

//2 Принимает два целых числа и возвращает их сумму.
fun getSum(a: Int, b: Int): Int = a + b

//3 Принимает строку и ничего не возвращает.
fun greetClient(name: String) {
    println("Hello, $name!")
}

//4 Принимает список целых чисел и
// возвращает среднее значение типа Double.
fun getAverage(numbers: List<Int>): Double {
    return numbers.average()
}


//5 Принимает nullable строку и
// возвращает её длину в виде nullable целого числа и
// доступна только в текущем файле.
private fun getLength(str: String?): Int? {
    return str?.length
}

//6 Не принимает аргументов и
// возвращает nullable вещественное число.
fun getRealNumber(): Double? {
    val numbers = listOf(-1.2, 1.0, 0.0, 3.5, -1.78)
    return if (numbers.size >= 100) numbers[100] else null
}

//7 Принимает nullable список целых чисел,
// не возвращает значения и доступна только в текущем файле.
private fun printList(numbers: List<Int>?) {
    if (numbers.isNullOrEmpty()) {
        println("List is empty")
    } else {
        for (number in numbers) {
            println(number)
        }
    }
}

//8 Принимает целое число и возвращает nullable строку.
fun getAdvice(temperature: Int): String? =
    if (temperature in -50..50) "You live in normal space" else null


//9 Не принимает аргументов и
// возвращает список nullable строк.
fun getListOfString(): List<String?> {
    val string = "To be or not to be, that is the question."
    return string.split(" ")
}

//10 Принимает nullable строку и nullable целое число и
// возвращает nullable булево значение.
fun getGuestInfo(name: String?, age: Int?): Boolean? {
    return if (name != null && age != null) {
        name.endsWith("a") && age >= 18
    } else {
        null
    }
}

// Задачи на написание кода.
//Напишите валидную сигнатуру метода,
// а также рабочий код для задач.

//11 Напишите функцию multiplyByTwo,
// которая принимает целое число и возвращает его,
// умноженное на 2.
fun multiplyByTwo(number: Int): Int = number * 2

//12 Создайте функцию isEven, которая принимает целое число и
// возвращает true, если число чётное, и
// false в противном случае.
fun isEven(number: Int): Boolean = number % 2 == 0

//13 Напишите функцию printNumbersUntil,
// которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение
// с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int) {
    if (n < 1) {
        return
    }
    for (i in 1..n) {
        println(i)
    }
}

//14 Создайте функцию findFirstNegative,
// которая принимает список целых чисел и
// возвращает первое отрицательное число в списке.
// Если отрицательных чисел нет,
// функция должна вернуть null.
fun findFirstNegative(numbers: List<Int>): Int? {
    for (number in numbers) {
        if (number < 0) {
            return number
        }
    }
    return null
}

//15 Напишите функцию processList,
// которая принимает список строк.
// Функция должна проходить по списку и
// выводить каждую строку.
// Если встречается null значение,
// функция должна прекратить выполнение с помощью return
// без возврата значения.
fun processList(cars: List<String?>) {
    for (car in cars) {
        if (car == null) {
            return
        }
        println(car)
    }
}
