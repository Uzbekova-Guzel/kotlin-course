package com.guzeluz.kotlincourse.lessons.lesson31

import java.time.LocalDate

class Discounter {

    fun calculateSingleDiscount(profile: ClientProfile, price: Double, count: Int): Double {
        var coefficient = 1.0
        if (profile.getAge() >= 60) {
            coefficient -= 0.1
        }
        if (profile.getAge() in 18..20) {
            coefficient -= 0.05
        }

        when {
            profile.moreThanPurchases(100) -> coefficient -= 0.1
            profile.moreThanPurchases(50) -> coefficient -= 0.08
            profile.moreThanPurchases(10) -> coefficient -= 0.04
        }
        when {
            count > 100 -> coefficient -= 0.1
            count > 50 -> coefficient -= 0.08
            count > 10 -> coefficient -= 0.04
        }
        val lastActivity = profile.getLastActivity()
        val lasWeek = LocalDate.now().minusDays(7)
        val lastMonth = LocalDate.now().minusMonths(1)
        if (lastActivity.isAfter(lasWeek)) {
            coefficient -= 0.03
        }
        if (lastActivity.isAfter(lastMonth)) {
            coefficient -= 0.02
        }
        return price * (1.0 - coefficient)
    }
}