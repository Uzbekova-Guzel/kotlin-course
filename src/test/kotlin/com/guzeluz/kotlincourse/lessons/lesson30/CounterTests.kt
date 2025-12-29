package com.guzeluz.kotlincourse.lessons.lesson30

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import kotlin.random.Random
import kotlin.test.assertEquals

class CounterTests {

    companion object {
        var counter: Counter? = null
        var initialValue: Int = 0

        @JvmStatic
        @BeforeAll
        fun setup() {
            initialValue = Random.nextInt(0, 100)
            println("Инициализация Counter с начальным значением $initialValue.")
            counter = Counter(initialValue)
        }

        @JvmStatic
        @AfterAll
        fun tearDown() {
            println("Очищаем ресурсы после тестов.")
            counter = null
        }
    }

    @Test
    fun testInitialState() {
        println("Проверка начального состояния счетчика.")
        assertEquals(initialValue, counter?.value, "Начальное состояние счетчика должно быть $initialValue.")
    }

    @Test
    fun testIncrement() {
        println("Тестирование инкремента.")
        counter?.increment()
        assertEquals(
            initialValue + 1,
            counter?.value,
            "После инкремента значение счетчика должно быть ${initialValue + 1}."
        )
    }

    @Test
    fun testDecrement() {
        println("Тестирование декремента.")
        counter?.decrement()
        assertEquals(
            initialValue - 1,
            counter?.value,
            "После декремента значение счетчика должно быть ${initialValue - 1}."
        )
    }
}

class Counter(var value: Int) {
    fun increment() {
        value++
    }

    fun decrement() {
        value--
    }
}
