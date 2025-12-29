package com.guzeluz.kotlincourse.lessons.lesson31.homework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class PhoneNumberFormatterParameterizedTest {

    private val phoneNumberFormatter = PhoneNumberFormatter()

    companion object {
        @JvmStatic
        fun provideCorrectNumbers() = listOf<Any>(
            arrayOf("8 (922) 941-11-11", "+7 (922) 941-11-11"),
            arrayOf("79229411111", "+7 (922) 941-11-11"),
            arrayOf("+7 922 941 11 11", "+7 (922) 941-11-11"),
            arrayOf("9229411111", "+7 (922) 941-11-11"),
            arrayOf("abc +7 922 941 11 11", "+7 (922) 941-11-11")
        )
    }

    @ParameterizedTest
    @MethodSource("provideCorrectNumbers")
    fun `should format correct numbers`(
        phone: String,
        expectedFormat: String
    ) {
        val actualFormat = phoneNumberFormatter.formatPhoneNumber(phone)
        assertEquals(expectedFormat, actualFormat)
    }

    @ParameterizedTest
    @ValueSource(strings = ["6 (922) 941-11-11", "09229411111", "+1 (922) 941-11-11"])
    fun `should throw exception for invalid first digit`(
        phone: String
    ) {
        assertThrows(IllegalArgumentException::class.java) {
            phoneNumberFormatter.formatPhoneNumber(phone)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "123456789", "123456789012", "&^*hfhj"])
    fun `should throw exception for invalid length`(
        phone: String
    ) {
        assertThrows(IllegalArgumentException::class.java) {
            phoneNumberFormatter.formatPhoneNumber(phone)
        }
    }
}
