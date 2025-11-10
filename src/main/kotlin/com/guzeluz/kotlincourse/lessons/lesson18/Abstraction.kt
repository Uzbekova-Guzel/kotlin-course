package com.guzeluz.kotlincourse.lessons.lesson18

interface Powerable {
    // Абстрактные методы без реализации
    fun turnOn()
    fun turnOff()
}

interface Device : Powerable1 {

    // Константа, определенная в companion object
    companion object {
        const val TYPE = "Device"
    }

    // Абстрактное свойство (поле), которое должно быть переопределено в классе, реализующем интерфейс
    val deviceId: String

    // Метод с реализацией, вызывающий приватный метод
    fun restart() {
        turnOff()
        logAction("Устройство с ID $deviceId выключено для перезагрузки.")
        turnOn()
        logAction("Устройство с ID $deviceId включено после перезагрузки.")
    }

    // Приватный метод с реализацией (доступно начиная с Kotlin 1.4)
    private fun logAction(action: String) {
        println("* Лог действия устройства: $action *")
    }
}

abstract class HouseholdAppliance(
    val brand: String
) : Device {

    abstract val applianceType: String

    var isPoweredOn: Boolean = false
        private set

    abstract fun operate()

    override fun turnOn() {
        isPoweredOn = true
        onPowerChange()
    }

    override fun turnOff() {
        isPoweredOn = false
        onPowerChange()
    }

    private fun onPowerChange() {
        val state = if (isPoweredOn) {
            "включено"
        } else {
            "выключено"
        }
        println("Устройство '$applianceType $brand' $state.")
    }

    protected open fun performMaintenance() {
        println("*** Секция обслуживания устройства ***")
    }
}

interface Programmable {

    fun selectProgram(preset: Int)
}

class Microwave(
    brand: String,
    serialNumber: String
) : HouseholdAppliance(brand), Programmable {

    private val programPresets = mapOf(
        1 to "warm up soup",
        2 to "warm up bread"
    )

    private var lastProgram = 1

    override val deviceId = serialNumber

    override val applianceType: String = "Микроволновая печь"

    override fun operate() {
        if (isPoweredOn) {
            invokeProgram()
            performMaintenance()
        } else {
            println("Микроволновая печь от $brand не включена. Пожалуйста, включите ее.")
        }
    }

    override fun performMaintenance() {
        super.performMaintenance()
        println("Чистка микроволновой печи от $brand.")
    }

    override fun selectProgram(preset: Int) {
        if (preset in programPresets) {
            lastProgram = preset
        }
    }

    private fun invokeProgram() {
        println(programPresets[lastProgram])
    }
}

fun main() {
    val mw = Microwave("Samsung", "CX45HGR-T10")
    println(mw.isPoweredOn)
    // mw.isPoweredOn = true // так нельзя
    println(mw.deviceId)
    mw.turnOn()
    mw.operate()
    mw.restart()
    mw.operate()
    mw.turnOff()
}

fun turnOff(list: List<Powerable1>) {
    list.forEach {
        it.turnOff()
    }
}
