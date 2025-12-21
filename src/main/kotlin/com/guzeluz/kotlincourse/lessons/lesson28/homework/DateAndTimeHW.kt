package com.guzeluz.kotlincourse.lessons.lesson28.homework

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

private val BOOMER_FROM = LocalDate.of(1946, 1, 1)
private val BOOMER_TO = LocalDate.of(1964, 12, 31)
private val ZOOMER_FROM = LocalDate.of(1997, 1, 1)
private val ZOOMER_TO = LocalDate.of(2012, 12, 31)

fun main() {
    //1. Создай текущую метку времени и выведи её на печать
    val rightMomentToLive = Instant.now()
    println(rightMomentToLive)

    //2. Создай дату своего дня рождения.
    val birthDate = LocalDate.of(1990, 1, 1)

    //3. Создай период между датой своего рождения и текущей датой.
    // Выведи на печать количество лет из этого периода.
    val age = Period.between(birthDate, LocalDate.now())
    println(age.years)

    //5. Создай объекты дат и / или времени которые мы изучили и по очереди
    // передай их в метод созданный выше. Не используй в них метод now()
    val localDate = LocalDate.of(2025, 12, 21)
    val localTime = LocalTime.of(9, 30, 0)
    val localDateTime = LocalDateTime.of(localDate, localTime)
    val zonedDateTime = ZonedDateTime.of(localDate, localTime, ZoneId.of("Europe/Berlin"))
    val offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.of("+01:00"))
    dateFormatter(localDate)
    dateFormatter(localTime)
    dateFormatter(localDateTime)
    dateFormatter(zonedDateTime)
    dateFormatter(offsetDateTime)

    //6
    LocalDate.of(1950, 5, 10).identifyGeneration() // Бумер
    LocalDate.of(2000, 3, 1).identifyGeneration()  // Зумер
    LocalDate.of(1985, 7, 20).identifyGeneration() // Не определено
    LocalDate.of(1946, 1, 1).identifyGeneration()  // Бумер
    LocalDate.of(1964, 12, 31).identifyGeneration() // Бумер
    LocalDate.of(1997, 1, 1).identifyGeneration()  // Зумер
    LocalDate.of(2012, 12, 31).identifyGeneration() // Зумер

    //7. Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года.
    // Создай форматтер, который форматирует дату в месяц и день.
    val firstDate = LocalDate.of(2023, 2, 25)
    val secondDate = LocalDate.of(2024, 2, 25)
    val formatter = DateTimeFormatter.ofPattern("MM-dd")

    //8. Выведи первую отформатированную дату, прибавив к ней 10 дней.
    println(firstDate.plusDays(10).format(formatter))
    //9. Выведи вторую отформатированную дату, прибавив к ней 10 дней.
    println(secondDate.plusDays(10).format(formatter))
}

/*4. Создай функцию, которая принимает тип Temporal и выводит
 форматированное значение в зависимости от того, содержит ли аргумент
 время и часовой пояс.
 Temporal - это общий тип для разных классов даты-времени.
 В форматированном значении нужно выводить часы, минуты,
 секунды и таймзону, если они представлены в переданном объекте.
 Обработай в методе все типы дат, которые знаешь.
 Реализуй два варианта функции - с собственным форматированием и
 с форматами из ISO коллекции.*/
fun dateFormatter(temporal: Temporal) {
    when (temporal) {
        is LocalDate -> "dd-MM-yyyy"
        is LocalTime -> "HH:mm:SS"
        is LocalDateTime -> "dd-MM-yyyy HH:mm:SS"
        is ZonedDateTime -> "dd-MM-YYYY HH:mm:ss z"
        is OffsetDateTime -> "dd-MM-YYYY HH:mm:ss ZZZ"
        else -> "It isn't date"
    }.let {
        DateTimeFormatter.ofPattern(it).format(temporal)
    }.also {
        println(it)
    }
}

/*6. Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку,
определяющую, к какому поколению принадлежит человек родившийся в эту дату:
"Бумер" для тех, кто родился с 1946 по 1964 год включительно, и
"Зумер" для тех, кто родился с 1997 по 2012 год включительно.
Если дата рождения не попадает ни в один из этих диапазонов, функция должна печатать "Не определено".
Для сравнения дат используй методы isAfter(otherDate) и isBefore(otherDate) или
проверку вхождения в диапазон. Объекты с эталонными датами вынеси в приватные поля файла
с методом identifyGeneration.*/
fun LocalDate.identifyGeneration() {
    when (this) {
        in BOOMER_FROM..BOOMER_TO -> println("Бумер")
        in ZOOMER_FROM..ZOOMER_TO -> println("Зумер")
        else -> println("Не определено")
    }
}
