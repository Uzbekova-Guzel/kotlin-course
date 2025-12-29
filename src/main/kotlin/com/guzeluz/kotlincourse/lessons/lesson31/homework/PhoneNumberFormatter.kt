package com.guzeluz.kotlincourse.lessons.lesson31.homework

class PhoneNumberFormatter {

    fun formatPhoneNumber(phone: String): String {
        val digitsOnly = phone.replace("\\D".toRegex(), "")

        val digits = when (digitsOnly.length) {
            10 -> digitsOnly
            11 -> {
                val first = digitsOnly.first()
                if (first != '7' && first != '8') {
                    throw IllegalArgumentException("Invalid country code: $first")
                }
                digitsOnly.drop(1)
            }

            else -> throw IllegalArgumentException(
                "Invalid number length: ${digitsOnly.length}"
            )
        }

        val areaCode = digits.substring(0, 3)
        val numberPart1 = digits.substring(3, 6)
        val numberPart2 = digits.substring(6, 8)
        val numberPart3 = digits.substring(8, 10)

        return "+7 ($areaCode) $numberPart1-$numberPart2-$numberPart3"
    }
}
