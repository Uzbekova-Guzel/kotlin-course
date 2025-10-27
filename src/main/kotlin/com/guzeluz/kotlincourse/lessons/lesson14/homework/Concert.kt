package com.guzeluz.kotlincourse.lessons.lesson14.homework

/*
5. Мероприятие: концерт.
Создайте класс, который будет представлять концерт.
У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
Также приватное поле “проданные билеты”.
Добавьте метод, который выводит информацию о концерте и
метод “купить билет”, который увеличивает количество проданных билетов на один.
 */

class Concert(val band: String, val location: String, val cost: Int, val capacity: Int) {

    private var soldTickets = 0

    fun buyTicket() {
        if (soldTickets < capacity) {
            soldTickets++
        }
    }

    fun printDetails() {
        println("The band: $band\nLocation: $location\nCost: $cost\nAvailable tickets: ${capacity - soldTickets}")
    }
}

fun main() {
    val concert = Concert("Rammstein", "Olympia Arena", 150, 500)
    concert.printDetails()
    concert.buyTicket()
    concert.printDetails()
}