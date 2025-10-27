package com.guzeluz.kotlincourse.lessons.lesson14

import java.time.LocalDate
import java.time.Period

class Passenger(
    val name: String,
    private val dateOfBirth: String,
    private var phone: String
) {

    private var age: Int = calculateAge()

    private fun calculateAge(): Int {
        return Period.between(
            LocalDate.parse(dateOfBirth),
            LocalDate.now()
        ).years
    }

    fun recalculateAge() {
        age = calculateAge()
    }
}