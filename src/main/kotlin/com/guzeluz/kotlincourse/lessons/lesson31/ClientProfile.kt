package com.guzeluz.kotlincourse.lessons.lesson31

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class ClientProfile(birthday: String = "1986.05.23") {

    private var lastActivity = LocalDate.of(2000, 1, 1)
    private var purchaseNumber = 0
    private val dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    private val birthday: LocalDate = LocalDate.parse(birthday, dateFormat)

    init {
        require(this.birthday.isBefore(LocalDate.now()))
    }

    fun addPurchase(date: LocalDate = LocalDate.now()) {
        lastActivity = date
        purchaseNumber++
    }

    fun getLastActivity(): LocalDate {
        return LocalDate.from(lastActivity)
    }

    /**
     * Возвращает true если на профиле покупок больше, чем переданное число
     */
    fun moreThanPurchases(numberForCompare: Int): Boolean {
        return purchaseNumber > numberForCompare
    }

    fun getAge(): Int {
        return Period.between(birthday, LocalDate.now()).years
    }
}