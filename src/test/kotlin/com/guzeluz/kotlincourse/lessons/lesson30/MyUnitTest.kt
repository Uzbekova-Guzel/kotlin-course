package com.guzeluz.kotlincourse.lessons.lesson30

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals

class MyUnitTest {
//    Используемые аннотации JUnit
//    @Test – указывает, что метод является тестовым.
//    @BeforeEach / @AfterEach – методы, помеченные этими аннотациями, выполняются до или после каждого теста соответственно.
//    @BeforeAll / @AfterAll – методы, помеченные этими аннотациями, выполняются один раз до начала всех тестов и после завершения всех тестов класса.

    @BeforeEach
    fun setUp() {

    }

    @Test
    fun additionalTest() {
        val calc = Calculator()
        assertEquals(5, calc.add(2, 3), "2 + 3 должно быть равно 5")
    }

    @Test
    @Ignore
    fun additionalTest2() {
        val calc = Calculator()
        assertEquals(5, calc.add(2, 2), "2 + 3 должно быть равно 5")
    }
}
