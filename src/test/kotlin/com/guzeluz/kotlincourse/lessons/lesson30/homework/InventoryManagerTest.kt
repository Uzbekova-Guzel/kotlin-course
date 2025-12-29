package com.guzeluz.kotlincourse.lessons.lesson30.homework

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InventoryManagerTest {
    private val inventoryManager = InventoryManager(10)

    @Test
    fun getItemCountInEmptyItems() {
        assertEquals(0, inventoryManager.getItemCount("car"))
    }

    @Test
    fun getItemCount() {
        with(inventoryManager) {
            addItem("car", 5)
            assertEquals(5, getItemCount("car"))
        }
    }

    @Test
    fun getMultipleItemCount() {
        with(inventoryManager) {
            addItem("house", 2)
            addItem("apartment", 3)
            assertEquals(2, getItemCount("house"))
            assertEquals(3, getItemCount("apartment"))
        }
    }
}
