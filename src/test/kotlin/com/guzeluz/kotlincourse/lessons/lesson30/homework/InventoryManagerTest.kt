package com.guzeluz.kotlincourse.lessons.lesson30.homework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InventoryManagerTest {
    private val inventoryManager = InventoryManager(5)

    @Test
    fun getItemCountInEmptyItems() {
        assertEquals(0, inventoryManager.getItemCount("car"))
    }

    @Test
    fun getItemCount() {
        with(inventoryManager) {
            addItem("car", 1)
            assertEquals(1, getItemCount("car"))
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

    @Test
    fun addItem() {
        with(inventoryManager) {
            addItem("bike", 2)
            assertEquals(2, getItemCount("bike"))
        }
    }

    @Test
    fun addSimilarItem() {
        with(inventoryManager) {
            addItem("bike", 1)
            addItem("bike", 2)
            assertEquals(3, getItemCount("bike"))
        }
    }

    @Test
    fun addExtraCapacityItems() {
        with(inventoryManager) {
            addItem("plane", 4)
            assertThrows(IllegalStateException::class.java) {
                addItem("plane", 2)
            }
        }
    }
}
