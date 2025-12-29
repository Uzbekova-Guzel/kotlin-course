package com.guzeluz.kotlincourse.lessons.lesson30

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RgbLampTest {
    private val lamp = RgbLamp()

    @BeforeEach
    fun setUp() {
        lamp.powerOn()
    }

    @Test
    fun `лампа включается`() {
        val lamp = RgbLamp()
        assertTrue { lamp.powerOn() }
    }

    @Test
    fun shouldBeRed() {
        lamp.setRed("1C")
        assertEquals("#1C0000", lamp.getColor())
    }

    @Test
    fun shouldBeThrown() {
        assertThrows(AssertionError::class.java) {
            lamp.setBlue("VV")
        }
    }
}
