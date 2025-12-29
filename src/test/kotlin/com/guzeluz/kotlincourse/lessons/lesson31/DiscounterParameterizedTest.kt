package com.guzeluz.kotlincourse.lessons.lesson31

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DiscounterParameterizedTest {

    @ParameterizedTest
    @MethodSource("provideDiscountData")
    fun `should calculate age discounted price correctly`(
        dateOfBirth: String,
        price: Double,
        discount: Double
    ) {
        val profile = ClientProfile(dateOfBirth)
        val discounter = Discounter()
        val actualDiscount = discounter.calculateSingleDiscount(profile, price, 1)
        assertEquals(discount, actualDiscount, 0.01)

    }

    @ParameterizedTest
    @MethodSource("provideCountOfPurchases")
    fun `should calculate purchase discounted price correctly`(
        purchaseCount: Int,
        price: Double,
        discount: Double
    ) {
        val profile = ClientProfile("1983.05.23")
        val discounter = Discounter()
        for (i in 1..purchaseCount) {
            profile.addPurchase(LocalDate.of(1977, 12, 1))
        }
        val actualDiscount = discounter.calculateSingleDiscount(profile, price, 1)
        assertEquals(discount, actualDiscount, 0.01)
    }

    companion object {
        @JvmStatic
        fun provideDiscountData(): List<Array<out Any>> {
            val dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd")
            val sixtyYearsBirthday = LocalDate.now()
                .minusYears(60)
                .format(dateFormat)
            val lessThanSixtyYearsBirthday = LocalDate.now()
                .minusYears(60)
                .plusDays(1)
                .format(dateFormat)
            val moreThanSixtyYearsBirthday = LocalDate.now()
                .minusYears(60)
                .minusDays(1)
                .format(dateFormat)
            return listOf(
                arrayOf(sixtyYearsBirthday, 100.0, 10.0),
                arrayOf(lessThanSixtyYearsBirthday, 100.0, 0.0),
                arrayOf(moreThanSixtyYearsBirthday, 100.0, 10.0)
            )
        }

        @JvmStatic
        fun provideCountOfPurchases() = listOf(
            arrayOf(4, 100.0, 0.0),
            arrayOf(11, 100.0, 4.0),
            arrayOf(51, 100.0, 8.0),
            arrayOf(101, 100.0, 10.0)
        )
    }
}
