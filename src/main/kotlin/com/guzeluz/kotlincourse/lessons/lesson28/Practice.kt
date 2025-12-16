package com.guzeluz.kotlincourse.lessons.lesson28

import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun main() {
//1. Создай текущую метку времени.
    val arg1 = Instant.now()

//2. Создай метку времени из Long значения
    val arg2 = Instant.ofEpochSecond(-99999)
    println(arg2)

//3. Создай дату дня знаний в 2023 году
    val arg3 = LocalDate.of(2023, 9, 1)

//4. Создай дату последнего дня весны 2025 года
    val arg4 = LocalDate.of(2025, 5, 31)

//5. Вычисли период между датами и выведи её в неделях
    val arg5 = Period.between(arg3, arg4)
    println(arg5)

//6. Создай период из 2 лет, 3 месяцев и 24 дней
    val arg6 = Period.of(2, 3, 24)

//7. Добавь этот период к дате последнего дня весны,
// выведи в формате год-месяц-день
    println(arg4 + arg6) //P1Y8M30D

//8. Создай запись для календаря (дату и время) -
// планирование спринта на ближайший понедельник,
// 10 утра московского времени
    val arg8 = ZonedDateTime.of(2025, 12, 22, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"))
    val date = LocalDate.of(2025, 12, 22)
    val time = LocalTime.of(10, 0, 0)
    val dateTime = ZonedDateTime.of(date, time, ZoneId.of("Europe/Moscow"))
    val dateTime1 = date.atTime(time).atZone(ZoneId.of("Europe/Moscow"))

//9. Прибавь к дате планирования 11 дней и пять часов,
// выведи дату закрытия спринта в отформатированном виде.
    val arg9 = dateTime.plusDays(11).plusHours(5)
    val formatter = DateTimeFormatter.ofPattern("'Days:' dd', Hours:' HH")
    println(dateTime.format(formatter))

//10. Умножь период из пункта 6 на 2 методом multipliedBy(),
// распечатай результат и объясни его.
    val arg10 = arg6.multipliedBy(2)
    println(arg10) //P4Y6M48D
}
