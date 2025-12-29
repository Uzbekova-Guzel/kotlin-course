package com.guzeluz.kotlincourse.lessons.lesson31

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertFailsWith

class DiscountCalculatorParameterizedTest {
    @ParameterizedTest
    @MethodSource("provideDiscountData")
    fun `should calculate discounted price correctly`(
        originalPrice: Double,
        discountPercentage: Int,
        expectedPrice: Double
    ) {
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(expectedPrice, actualPrice, 0.01, "Цена после скидки рассчитана неверно")
    }

    @ParameterizedTest
    @MethodSource("provideInvalidPrices")
    fun `should throw exception for invalid original price`(originalPrice: Double, discountPercentage: Int) {
        assertFailsWith<IllegalArgumentException>("Цена должна быть неотрицательной") {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDiscounts")
    fun `should throw exception for invalid discount percentage`(discountPercentage: Int) {
        assertFailsWith<IllegalArgumentException>("Скидка должна быть от 0 до 100%") {
            calculateDiscountedPrice(100.0, discountPercentage)
        }
    }

    companion object {
        @JvmStatic
        fun provideDiscountData() = listOf(
            arrayOf(100.0, 0, 100.0),   // Без скидки
            arrayOf(200.5, 49, 102.255), // Неровная цена и скидка
            arrayOf(50.0, 100, 0.0),   // Полная скидка
            arrayOf(99.99, 25, 74.99)  // 25% скидка и дробная цена
        )

        @JvmStatic
        fun provideInvalidPrices() = listOf(
            arrayOf(-0.01, 10), // Отрицательная цена
            arrayOf(-1.0, 0),  // Отрицательная цена без скидки
            arrayOf(-0.01, 100), // Отрицательная цена и полная скидка
        )

        @JvmStatic
        fun provideInvalidDiscounts() = listOf(
            arrayOf(-1),  // Скидка меньше 0
            arrayOf(101)   // Скидка больше 100
        )
    }
}